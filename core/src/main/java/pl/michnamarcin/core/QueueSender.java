package pl.michnamarcin.core;

import pl.michnamarcin.db.service.TaskService;


import javax.jms.*;
import javax.naming.InitialContext;


public class QueueSender
{
    private TaskService taskService = new TaskService();

    public void send(int id)
    {
        System.out.println("QueueSender -> send");
        try
        {
            InitialContext initialContext = new InitialContext();
            QueueConnectionFactory factory = (QueueConnectionFactory) initialContext.lookup("ConnectionFactory");
            Connection conn = factory.createConnection();
            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue q = session.createQueue("QueueSOA");
            MessageProducer mp = session.createProducer(q);

            conn.start();
            mp.send(session.createTextMessage(String.valueOf(id)));
            conn.close();

        }
        catch(Exception e)
        {
            e.getMessage();
        }


    }
}
