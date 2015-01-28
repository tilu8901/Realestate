package model;

public class SaleProperty extends Property
{
    private String buyer;
    public SaleProperty(int id, double price, String owner)
    {
        super(id, price, owner);
        state = State.FOR_SALE;
    }
    public void sell(int month, String buyer, Agent agent)
    {
        state = State.SOLD;
        this.month = month;
        this.buyer = buyer;
        this.agent = agent;
    }
    public double income(int month)
    {
        if(!isForSale()&& this.month == month)
            return price;
        else
            return ZERO;
    }
    
}