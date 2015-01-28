package model;
import java.text.*;
import java.util.*;

public class Agency extends Updater  
{
    private Agents agents = new Agents();
    private Properties properties = new Properties();
    private Records records = new Records();
    private int month = 0;
    private double balance = 0.0;
    private final char YES = 'Y';
    private final int RENT = 1;
    private final int SELL = 2;
    public Agency()
    {
        
    }

    
    public void endMonth()
    {
        balance += income();
        System.out.println("New Month is " + ++month);
        updateViews();
        
    }   
    public String report()
    {
        String s = agents.toString();
        s += "\n";
        s += properties.toString();
        s += "\n";
        s += toString();
        return s;
    }
    
    public void showReport()
    {
        System.out.println(report());
    }
    
    
    public double income()
    {
        return properties.income(month);
    }
    
   
    public Properties getProperties()
    {
        return properties;
    }
    public Agents getAgents()
    {
        return agents;
    }
    public int getMonth()
    {
        return month;
    }
    public double getBalance()
    {
        return balance;
    }
    public void show()
    {
        System.out.println(toString());
    }
    public static String formatted(double amount)
    {   
        DecimalFormat formatter = 
            new DecimalFormat("###,##0.00");
        return formatter.format(amount); 
    }
    public String toString()
    {   String s = "Derelict Real Estate:";
        s += " month " + month;
        s += " income = $" + formatted(income());
        s += " balance = $" + formatted(balance);
        return s;
    }
}
