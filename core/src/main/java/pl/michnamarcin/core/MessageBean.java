package pl.michnamarcin.core;

import pl.michnamarcin.db.service.TaskService;

import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "queues/myQueue")
public class MessageBean implements MessageListener
{
    @Override
    public void onMessage(Message message)
    {
        TaskService taskService = new TaskService();
        try
        {
            if(message instanceof TextMessage)
            {
                TextMessage txtMsg = (TextMessage) message;
                String msg = txtMsg.getText();
                taskService.endTask(Integer.parseInt(msg));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
