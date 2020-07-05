package pl.michnamarcin.db.dao;

import pl.michnamarcin.db.model.Task;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.util.Calendar;

public class TaskDAO
{
    private static EntityManager em = Persistence.createEntityManagerFactory("MySqlDS").createEntityManager();

    public Task findById(int id)
    {
        return em.find(Task.class, id);
    }

    public int add(Task toAdd)
    {
        try
        {
            em.getTransaction().begin();
            em.persist(toAdd);
            em.getTransaction().commit();
            return toAdd.getId();
        }
        catch(Exception e)
        {
            System.out.println("Couldn't add task");
            em.getTransaction().rollback();
            return -1;
        }
    }

    public void endTask(int id)
    {
        try
        {
            Task task = em.find(Task.class, id);
            em.getTransaction().begin();
            task.setEnd(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            System.out.println("Couldn't end task");
            em.getTransaction().rollback();
        }
    }
}
