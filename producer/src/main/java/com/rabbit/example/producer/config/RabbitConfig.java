package com.rabbit.example.producer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/***
 * 　Direct Exchange是RabbitMQ默认的交换机模式，也是最简单的模式，根据key全文匹配去寻找队列。
 */
@Configuration
public class RabbitConfig {

    @Value("${spring.rabbitmq.host}")
    private String addresses;

    @Value("${spring.rabbitmq.port}")
    private String port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;

    //声明hello队列名称
    public static final  String HELLO_QUEUE_NAME = "helloQueue";
    //声明user队列名称
    public static final  String USER_QUEUE_NAME = "user";


    /**
     *  声明　hello 队列
     * @return
     */
    @Bean
    public Queue helloQueue() {
        return new Queue(HELLO_QUEUE_NAME);
    }

    /**
     * 声明　user 队列
     * @return
     */
    @Bean
    public  Queue userQueue() {
        return new Queue(USER_QUEUE_NAME);
    }


    /**
     *
     * @return
     */
    @Bean
    public ConnectionFactory connectionFactory() {

        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
       connectionFactory.setAddresses(addresses + ":" + port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        /** 如果要进行消息回调，则这里必须要设置为true */
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    /**
     *
     * @return
     */
    @Bean
    /** 因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置 */
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplatenew() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }

}
