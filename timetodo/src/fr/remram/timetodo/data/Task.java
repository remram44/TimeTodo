package fr.remram.timetodo.data;

public class Task {

    int id;
    public String name;
    public int period;

    public Task(String name, int period)
    {
        this.id = -1;
        this.name = name;
        this.period = period;
    }

    Task(int id, String name, int period)
    {
        this(name, period);
        this.id = id;
    }

}
