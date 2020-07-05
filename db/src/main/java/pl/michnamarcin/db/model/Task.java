package pl.michnamarcin.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "task")
public class Task
{
    @Id
    private int id;

    @Column(name = "user_data")
    private String userData;

    @Column(name = "start_time")
    private Date start;

    @Column(name = "end_time")
    private Date end;

    public Task(String userData, Date start, Date end)
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

    public Date getStart()
    {
        return start;
    }

    public void setStart(Date start)
    {
        this.start = start;
    }

    public Date getEnd()
    {
        return end;
    }

    public void setEnd(Date end)
    {
        this.end = end;
    }
}
