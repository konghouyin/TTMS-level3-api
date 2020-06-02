package com.xupt.ttms.Service;

import com.xupt.ttms.dto.data;
import com.xupt.ttms.enums.PlayEnum;
import com.xupt.ttms.mapper.PlayMapper;
import com.xupt.ttms.model.Play;
import com.xupt.ttms.model.PlayExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayService {

    @Autowired
    PlayMapper mapper;

    public List<Play> getRecommend(){
        PlayExample example = new PlayExample();
        example.createCriteria().andPlayRecommendIsNotNull();

        List<Play> plays = mapper.selectByExample(example);
        return plays;
    }


    public List<Play> getlink(){
        PlayExample example = new PlayExample();
        example.createCriteria().andPlayLinkNotEqualTo("");

        List<Play> plays = mapper.selectByExample(example);
        return plays;
    }

    @Transactional
    public int updatePlay(data data){
        Play play1 = mapper.selectByPrimaryKey(data.getPlayId());
        if(play1==null){
            return 2;
        }

        PlayExample example = new PlayExample();
        example.createCriteria().andPlayIdEqualTo(data.getPlayId());

        Play play = new Play();
        try{
            if(data.getType()== PlayEnum.RECOMM.getType()){
                short a = 1;
                play.setPlayRecommend(a);
                mapper.updateByExampleSelective(play,example);
            }else {
                play.setPlayLink(data.getMsg());
                mapper.updateByExampleSelective(play,example);
            }
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

        return 1;
    }
}
