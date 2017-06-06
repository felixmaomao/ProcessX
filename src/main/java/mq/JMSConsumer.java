package mq;/**
 * Created by shenwei on 2017/3/24.
 */
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * @author shenwei
 * @create 2017-03-24
 */
public class JMSConsumer {
    //默认连接用户名
    private static final String USERNAME = "admin";
    //默认连接密码
    private static final String PASSWORD = "admin";
    //默认的连接地址
    private static final String BROKEURL = "tcp://192.168.137.107:61616";

    public static void main(String[] args) {
        ConnectionFactory factory ; //连接工厂
        Connection connection = null ; //连接
        Session session ; //会话，接收或者发送消息的线程
        Destination destination; //消息的目的地
        MessageConsumer messageConsumer; //消息消费者
        //实例化连接工厂
        factory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD, JMSConsumer.BROKEURL);
        //通过连接工厂获取connection
        try {
            connection = factory.createConnection();
            connection.start(); //启动连接
            //创建session
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            //创建连接消息队列,消息到达的目的地
//          destination = session.createQueue("FirstQueue");
            destination = session.createTopic("loginBehaviour");
            //创建消费者
            messageConsumer = session.createConsumer(destination);
            //注册消息监听
            messageConsumer.setMessageListener(new Listener());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
