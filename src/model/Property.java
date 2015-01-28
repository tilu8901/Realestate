package model;


public abstract class Property extends Record
{
    protected double price;
    protected String owner;
    protected Agent agent;
    protected State state;
    protected int month = 0;
    protected final double ZERO = 0.0;

    public Property(int id, double price, String owner)
    {
        super(id);
        this.price = price;
        this.owner = owner;
    }
    public boolean matches(Agent agent)
    {
        return this.agent.equals(agent);
    }
    public abstract double income(int month);
    public boolean isForSale()
    {
        return state == State.FOR_SALE;
    }
    public boolean isVacant()
    {
        return state == State.VACANT;
    }
    public String getState()
    {
        return state.toString();
    }
    public String toString()
    {
        return "Property" + super.toString() + ": price $" + Agency.formatted(price);
    }
    
}
