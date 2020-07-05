package pl.michnamarcin.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "task")
public class Task
{
    @Id
    private int id;

    @Column(name = "user_data")
    private String userData;

    @Column(name = "start_time")
    private Timestamp start;

    @Column(name = "end_time")
    private Timestamp end;

    public Task(String userData, Timestamp start, Timestamp end)
    {
        this.userData = userData;
        this.start = start;
        this.end = end;
    }

    public Task()
    {
    }

    @Override
    public String toString()
    {
        return "Task{" +
                "id=" + id +
                ", userData='" + userData + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUserData()
    {
        return userData;
    }

    public void setUserData(String userData)
    {
        this.userData = userData;
    }

    public Timestamp getStart()
    {
        return start;
    }

    public void setStart(Timestamp start)
    {
        this.start = start;
    }

    public Timestamp getEnd()
    {
        return end;
    }

    public void setEnd(Timestamp end)
    {
        this.end = end;
    }
}
