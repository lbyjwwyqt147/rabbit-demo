package com.rabbit.example.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 *
 *   Topic 是RabbitMQ中最灵活的一种方式，可以根据binding_key自由的绑定不同的队列
 */
@Configuration
public class TopicRabbitConfig {

    static final  String MESSAGE = "topic.message";
    static final  String MESSAGES = "topic.messages";

    /**
     * 创建队列　　　topic.message
     * @return
     */
    @Bean
    public Queue queueMessage() {
        return new Queue(TopicRabbitConfig.MESSAGE);
    }

    /**
     *　创建队列　　topic.messages
     * @return
     */
    @Bean
    public Queue queueMessages() {
        return new Queue(TopicRabbitConfig.MESSAGES);
    }

    /**
     *　定义Topic 交换器
     * @return
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    /**
     *　将队列　topic.message　绑定到Topic 交换器   这种方式　　监听　topic.message　topic.messages　的消费者都能收到发送的信息　
     * @param queueMessage
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        //第一个参数 是需要绑定的队列
        //第二个参数 是绑定的交换机
        //第三个参数 是路由键
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    /**
     *　将队列　topic.messages　绑定到Topic 交换器　　这种方式只有监听　topic.messages　才能收到消息
     * @param queueMessages
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

}
