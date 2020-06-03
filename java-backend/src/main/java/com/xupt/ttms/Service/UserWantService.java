package com.xupt.ttms.Service;

import com.xupt.ttms.dto.returnUTO;
import com.xupt.ttms.mapper.PlayMapper;
import com.xupt.ttms.mapper.UserWantMapper;
import com.xupt.ttms.model.Play;
import com.xupt.ttms.model.UserExample;
import com.xupt.ttms.model.UserWant;
import com.xupt.ttms.model.UserWantExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserWantService {
    @Autowired
    UserWantMapper wantMapper;
    @Autowired
    PlayMapper playMapper;

    @Transactional
    public int getByPlayId( Integer playId,Integer userId) {

        UserWantExample example = new UserWantExample();
        example.createCriteria().andPlayIdEqualTo(playId)
                .andUserIdEqualTo(userId);

        List<UserWant> userWants;

        try {
            userWants = wantMapper.selectByExample(example);
            if(userWants.size()>0){
                return 1;
            }else return 0;
        }catch (Exception e){
            e.printStackTrace();
            return -2;
        }
    }

    @Transactional
    public int wantDel(Integer playId, Integer userId) {
        int byPlayId = getByPlayId(playId, userId);

        if (byPlayId==1){
            UserWantExample example = new UserWantExample();
            example.createCriteria().andUserIdEqualTo(userId)
                    .andPlayIdEqualTo(playId);

            int i;
            try{
                i = wantMapper.deleteByExample(example);
            }catch (Exception e){
                e.printStackTrace();
                return -2;
            }
            if(i==0){
                return -2;
            }else{
                return 1;
            }
        }
        else {
            return 0;
        }
    }

    @Transactional
    public int wantAdd(Integer playId,Integer userId){
        int byPlayId = getByPlayId(playId, userId);

        if(byPlayId==0){
            UserWant userWant = new UserWant();
            userWant.setUserId(userId);
            userWant.setPlayId(playId);

            int insert;
            try{
                insert = wantMapper.insert(userWant);
            }catch (Exception e){
                e.printStackTrace();
                return -2;
            }
            if(insert==0){
                return -2;
            }else return 1;
        }
        else {
            return 0;
        }
    }

    public List getAll(Integer userId) {
        UserWantExample example = new UserWantExample();
        example.createCriteria().andUserIdEqualTo(userId);

        List<UserWant> userWants = wantMapper.selectByExample(example);
        List<Object> all = new ArrayList<>();
        for (UserWant userwant:userWants
             ) {
            Play play = playMapper.selectByPrimaryKey(userwant.getPlayId());
            all.add(play);
        }
        return all;
    }
}
