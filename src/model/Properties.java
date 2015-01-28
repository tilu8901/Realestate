package model;

import java.util.*;
public class Properties extends Records
{
   private final int RENT = 1;
   private final int SELL = 2;
    public Properties()
    {
       
    }
    public void addRental(double price, String owner)
    {
        add(new RentalProperty(++id, price,owner));
        updateViews();
    }
    public void addSale(double price, String owner)
    {
        add(new SaleProperty(++id, price, owner));
        updateViews();
    }
    public boolean canProcess(int id, int action)
    {
        if(isValid(id))
        {
            Property property = (Property)find(id);
            if (action == RENT)
            {
                return canRent(id,property);
            }
            else
                return canSell(id,property);
        }
        return false;
    }
    private boolean canRent(int id,Property property)
    {
        if (property.isVacant())
        {
            return true;
        }
        else
            sayError(id, property);
        return false;
    }
    private void sayError(int id, Property property)
    {
        System.out.println("Property id " + id + " is " + property.getState() + ". Request Denied.");
    }
    
     private boolean canSell(int id,Property property)
    {
        if (property.isForSale())
        {
            return true;
        }
        else
            sayError(id, property);
        return false;
    }
    public void rent(int id, int month, String tenant, Agent agent)
    { 
       RentalProperty rental = (RentalProperty)find(id);
       rental.rent(month, tenant, agent);
       updateViews();
    }
    public void sell(int id, int month, String buyer, Agent agent)
    {
        SaleProperty sale = (SaleProperty)find(id);
        sale.sell(month, buyer, agent);
        updateViews();
    }
    public double income(int month)
    {
        double income = 0.0;
        for (Record record : records)
        {      
            income += ((Property)record).income(month);
        }
        return income;
    }
   
    
    public String toString()
    {
        String s = "Properties";
        s += super.toString();
        return s;
    }
   
}
