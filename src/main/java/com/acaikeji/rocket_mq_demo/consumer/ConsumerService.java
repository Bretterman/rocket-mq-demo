package com.acaikeji.rocket_mq_demo.consumer;

import java.util.List;

import com.acaikeji.rocket_mq_demo.event.MessageEvent;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 监听消息进行消费
 */
@Component
@Async
public class ConsumerService {

    @EventListener
    public void rocketmqMsgListener2(MessageEvent event) {
        String name = Thread.currentThread().getName();
        System.out.println("name2 = " + name);
        try {
            List<MessageExt> msgs = event.getMsgs();
            for (MessageExt msg : msgs) {
                System.err.println("消费消息2:" + new String(msg.getBody()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @EventListener(condition = "#event.msgs[0].topic=='user-topic' && #event.msgs[0].tags=='white'")
    public void rocketmqMsgListener(MessageEvent event) {
        String name = Thread.currentThread().getName();
        System.out.println("name = " + name);
        try {
            Thread.sleep(5000L);
            List<MessageExt> msgs = event.getMsgs();
            for (MessageExt msg : msgs) {
                System.err.println("消费消息:" + new String(msg.getBody()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
