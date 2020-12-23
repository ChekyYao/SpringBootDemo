package com.cheky.springboot.demo.controller.mq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * topic 消息的topic
 * consumerGroup springboot 配置文件中配置的消息group
 *
 * @author cheky
 * @date
 */
@RocketMQMessageListener(topic = "mygroup2",consumerGroup = "${rocketmq.consumer.group}")
@Component
public class RocketMQListenerImpl implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        // 处理消息...
        System.out.println("收到MQ消息：" + s);
    }
}