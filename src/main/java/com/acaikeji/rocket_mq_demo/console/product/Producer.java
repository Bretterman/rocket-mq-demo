package com.acaikeji.rocket_mq_demo.console.product;
 
import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
 import com.acaikeji.rocket_mq_demo.console.model.User;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;


/**
* @Author 18011618
* @Date 10:41 2018/7/17
* @Function 消息生产者
*/
public class Producer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("test-group");
        producer.setNamesrvAddr("localhost:9876");
        producer.setInstanceName("rmq-instance");
        producer.start();
        try {
            for (int i = 0; i < 100; i++) {
                User user = new User();
                user.setLoginName("abc" + i);
                user.setPwd(String.valueOf(i));
                Message message = new Message("log-topic", "user-tag", JSON.toJSONString(user).getBytes());
                System.out.println("生产者发送消息:" + JSON.toJSONString(user));
                SendResult send = producer.send(message);
                System.out.println(send.getSendStatus());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.shutdown();
    }

}