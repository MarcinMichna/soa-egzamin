package pl.michnamarcin.core;

import javax.annotation.Resource;
import javax.jms.*;

public class QueueHandler
{
    @Resource(lookup = "java:/queues/myQueue")
    private Queue myQueue;

    @Resource(mappedName = "java:/JmsXA")
    private static ConnectionFactory cf;

    private Connection connection;

    public void send(int id)
    {
        try
        {
            connection = cf.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer publisher = session.createProducer(myQueue);

            connection.start();

            TextMessage message = session.createTextMessage(String.valueOf(id));
            publisher.send(message);


        } catch(Exception e)
        {
            e.printStackTrace();
        } finally
        {
            if(connection != null)
            {
                try
                {
                    connection.close();
                } catch(JMSException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
