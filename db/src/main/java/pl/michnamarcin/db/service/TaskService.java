package pl.michnamarcin.db.service;

import pl.michnamarcin.db.dao.TaskDAO;
import pl.michnamarcin.db.model.Task;

import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import java.util.Calendar;

@Stateful
@TransactionManagement
public class TaskService
{
    private TaskDAO taskDAO = new TaskDAO();

    public Task findById(int id)
    {
        return taskDAO.findById(id);
    }

    public int add(String data)
    {
        Task toAdd = new Task();
        toAdd.setUserData(data);
        toAdd.setStart(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
        return taskDAO.add(toAdd);
    }

    public void endTask(int id)
    {
        taskDAO.endTask(id);
    }

    public boolean check(int id)
    {
        Task task = findById(id);
        try
        {
            return task.getEnd() != null;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
