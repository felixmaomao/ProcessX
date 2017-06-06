package mq;/**
 * Created by shenwei on 2017/3/24.
 */
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * @author shenwei
 * @create 2017-03-24
 */
public class Listener implements MessageListener{
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("订阅者一收到的消息：" + ((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
