package model;


public class RentalProperty extends Property
{
    private String tenant = "no tenant";
    public RentalProperty(int id, double price, String owner)
    {
        super(id, price, owner);
        state = State.VACANT;
    }
    public void rent(int month, String tenant, Agent agent)
    {
        state = State.RENTED;
        this.month = month;
        this.tenant = tenant;
        this.agent = agent;
    }
    public void vacate()
    {
        state = State.VACANT;
        tenant = "";
        month = 0;
        agent = null;
    }
    public double income(int month)
    {
        if(!isVacant())
            return price;
        else
            return ZERO;
    }
    public String toString()
    {
        String s = super.toString();
        if(isVacant())
            s += " with " + tenant;
        else
            s += " tenant is " + tenant;
        return s;
    }
}
