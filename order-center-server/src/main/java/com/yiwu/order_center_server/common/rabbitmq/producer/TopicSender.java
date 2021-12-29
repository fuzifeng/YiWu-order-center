package com.yiwu.order_center_server.common.rabbitmq.producer;

import com.google.gson.Gson;
import com.yiwu.order_center_server.common.rabbitmq.dto.EsRabbitmqInfoDto;
import com.yiwu.order_center_server.config.RabbitConfig;
import com.yiwu.order_center_server.domain.RawMaterials;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.yiwu.order_center_server.config.TopicRabbitConfig.TOPIC_EXCHANGE;

/**
 * @Author: fuzf
 * @Date: 2020/11/2 18:08
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send1(String str) {
        String context = "hi, i am message 1; order:" + str;
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend(TOPIC_EXCHANGE, "topic.message", context);
    }


    public void send2(String str) {
        String context = "hi, i am messages 2; order:" + str;
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend(TOPIC_EXCHANGE, "topic.messages", context);
    }

    public void sendOrder(String str) {
        String context = "hi, i am order message; order:" + str;
        System.out.println(new Date());
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend(RabbitConfig.DELAY_EXCHANGE, RabbitConfig.DELAY_ROUTING_KEY, context, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
//                message.getMessageProperties().setExpiration("60000");
                message.getMessageProperties().setHeader("x-delay","10000");
                return message;
            }
        });
//        this.rabbitTemplate.convertAndSend("order.exchange", "order.#", context);
    }


    @Async
    public void sendRawMaterial(Long id) {
        EsRabbitmqInfoDto dto = new EsRabbitmqInfoDto();
        dto.setId(id);
        dto.setType(EsRabbitmqInfoDto.TypeEnum.RAW_MATERIAL.getCode());
        this.rabbitTemplate.convertAndSend(TOPIC_EXCHANGE, "topic.es", new Gson().toJson(dto));
    }

}
