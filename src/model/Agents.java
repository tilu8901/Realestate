package model;

import java.util.*;
public class Agents extends Records
{
    public Agents()
    {
        
    }
    public void add(String name)
    {
        add(new Agent(++id, name));
        updateViews();
    }
    public String toString()
    {
       String s = "Agents";
       s += super.toString();
       return s;
    }
  
}
