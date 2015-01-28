package model;


public class Agent extends Record
{
    private String name;

    public Agent(int id, String name)
    {
        super(id);
        this.name = name;
    }
    public String toString()
    {
        return "Agent"+ super.toString() + ": " + name;
    }
    
}
