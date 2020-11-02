package com.yiwu.order_center_server.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: fuzf
 * @Date: 2020/11/2 16:06
 * <p>
 * 主题模式配置
 */
@Configuration
public class TopicRabbitConfig {

    final static String Q_TOPIC_MESSAGE_1 = "q_topic_message_1";
    final static String Q_TOPIC_MESSAGE_2 = "q_topic_message_2";
    final static String TOPIC_EXCHANGE = "mytopicexchange";



    @Bean("queueMessage1")
    public Queue queueMessage1() {
        return new Queue(TopicRabbitConfig.Q_TOPIC_MESSAGE_1,true);
    }

    @Bean("queueMessage2")
    public Queue queueMessage2() {
        return new Queue(TopicRabbitConfig.Q_TOPIC_MESSAGE_2,true);
    }

    /**
     * 声明一个topic类型的交换机
     *
     * @return
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(TOPIC_EXCHANGE, true, false);
    }

    @Bean
    Binding bindingExchangeMessage1(@Qualifier("queueMessage1") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessage2(@Qualifier("queueMessage2") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.#");
    }

}
