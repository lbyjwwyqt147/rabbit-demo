package com.rabbit.example.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout转发器发送消息，绑定了这个转发器的所有队列都收到这个消息。
 */
@Configuration
public class FanoutRabbitConfig {

    /**
     * 创建队列　fanout.A
     * @return
     */
    @Bean
    public Queue fanoutAQuery() {
        return new Queue("fanout.A");
    }

    /**
     *　　创建队列　fanout.B
     * @return
     */
    @Bean
    public Queue fanoutBQuery() {
        return new Queue("fanout.B");
    }

    /**
     *　创建队列　fanout.C
     * @return
     */
    @Bean
    public Queue fanoutCQuery() {
        return new Queue("fanout.C");
    }

    /**
     *　定义交换机
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 将 fanout.A 队列绑定到Fanout交换机上面
     * @param fanoutAQuery
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingExchangeA(Queue fanoutAQuery, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutAQuery).to(fanoutExchange);
    }

    /**
     *  将 fanout.B 队列绑定到Fanout交换机上面
     * @param fanoutBQuery
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingExchangeB(Queue fanoutBQuery, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutBQuery).to(fanoutExchange);
    }

    /**
     * 将 fanout.C 队列绑定到Fanout交换机上面
     * @param fanoutCQuery
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingExchangeC(Queue fanoutCQuery, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutCQuery).to(fanoutExchange);
    }

}
