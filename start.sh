ps -ef|grep node-backend|grep -v grep|awk '{print "kill -9 "$2}'|sh
ps -ef|grep java-backend|grep -v grep|awk '{print "kill -9 "$2}'|sh
nohup node ./node-backend/tokenCheck/tokenCheck.js &
nohup node ./node-backend/server/managerServer.js &
nohup node ./node-backend/server/sale_server.js &
nohup node ./node-backend/server/user_server.js & 
nohup java -jar ./java-backend/target/ttms-0.0.1-SNAPSHOT.jar & 