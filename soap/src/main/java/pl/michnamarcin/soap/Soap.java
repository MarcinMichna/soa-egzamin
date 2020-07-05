package pl.michnamarcin.soap;

import pl.michnamarcin.core.Action;
import pl.michnamarcin.db.service.TaskService;

import javax.jws.WebService;

@WebService(endpointInterface = "pl.michnamarcin.soap.SoapI")
public class Soap implements SoapI
{
    //TaskService taskService = new TaskService();
    @Override
    public long push(String data)
    {
        //TaskService taskService = new TaskService();
        //int id = taskService.add(data);
        Action.action(13);
        return 13;
    }

    @Override
    public boolean check(int id)
    {
        return false; //taskService.check(id);
    }
}
