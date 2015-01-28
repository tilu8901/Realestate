package model;

import java.util.*;

public class Records extends Updater 
{
    protected int id = 0;
    protected LinkedList<Record> records = new LinkedList<Record>();
   
   
    
    
    
    
    public Records()
    {
    }
    
       public LinkedList<Record> records()
    {   
        return records;   
    }
    
    
    public void add(Record record)
    {
        records.add(record);   
        System.out.println(record.toString() + " added");
    }
    public Record find(int id)
    {   
        for (Record record : records)
        {   
            if (record.matches(id))
                return record;  
        }
        return null;    

    }
    public boolean isValid(int id)
    {
        if(find(id) != null)
        {
            return true;
        }
        else
            sayNotFound(id);
        return false;
    }
    private void sayNotFound(int id)
    {
        System.out.println("" + id + " not found. Request denied.");
    }
    public void remove (Record record)
    {
        records.remove(record);
    }
    public void show()
    {
        System.out.println(toString());
    }
    
  
    
    public String toString()
    {
        String s = "";
        for (Record record : records)
            s += "\n" + record.toString();
        return s;
    }
}
