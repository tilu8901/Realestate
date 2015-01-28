import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import model.*;

 public class Property extends JPanel implements MyObserver
    {
        private JLabel label = new JLabel("Property");
        private JTextField field = new JTextField(5);
        private JTextField field2 = new JTextField(5);
        private JButton find = new JButton("Find");
        private JTextField field3 = new JTextField(25);
        private JButton sell = new JButton("Sell");
        private JTextField field4 = new JTextField(10);
        private JButton rent = new JButton("Rent");
        private JLabel display = new JLabel("");
        private Agency agency;
        private Agents agents;
        private Properties properties;
        private Agent agent;
      
        
        public Property(Agency agency)
        {        
            this.agency = agency;
            this.agents = agents;
            this.properties = properties;
            this.agent = agent;
            agents = new Agents();
            setup();
            build();
         }
        
        private void setup()
        {
           label.setForeground(Color.pink);
           setBorder(BorderFactory.createLineBorder(Color.blue));
           find.addActionListener(new FindListener());
           sell.addActionListener(new SellListener());
           rent.addActionListener(new RentListener());
           agency.getAgents().attach(this);
           agency.getProperties().attach(this);
         }
        
         private void build()
        {
           add(label);
           addPair("Property id: ",field);
           addPair("Agent id: ",field2);
           add(find);
           addPair("Buyer ",field3);
           add(sell);
           addPair("Tenant ",field4);
           add(rent);
           add(display);
        }
        
        private void addPair(String label, JTextField field)
        { 
            add(new JLabel(label));
            add(field);    
        }
      
         
        public void findId()
      {
         Properties properties = agency.getProperties();
         Agents agents = agency.getAgents();
         
         if (PropertyId()==0 || AgentId()==0)
         {
            display.setText("Invalid ID(s)");  
         }
         else if (properties.isValid(PropertyId()) && agents.isValid(AgentId()))         {
               display.setText("ID(s) found");
         }
         else
         {
              display.setText("ID(s) not found");   
         }
      }
      
        public void sell()
      {
        Properties properties = agency.getProperties();
        Agents agents = agency.getAgents();
        Agent agent = (Agent) agents.find(AgentId());
        
        if (agent==null) 
        {
         System.out.println("Agent not found."); 
         display.setText("Agent not found.");
        }
        else if (properties.canProcess(PropertyId(),2))
        {
            properties.sell(PropertyId(),agency.getMonth(),field3.getText(), agent);
            display.setText("Sold property.");
        }
        else
        {
            display.setText("Request Denied") ;
        } 
      }
    
        public void rent()
      {
        Properties properties = agency.getProperties();
        Agents agents = agency.getAgents();
        Agent agent = (Agent) agents.find(AgentId());
        
        if (agent==null) 
        {
         System.out.println("Agent not found."); 
         display.setText("Agent not found.");
        }
        else if (properties.canProcess(PropertyId(),1))
        {
            properties.rent(PropertyId(),agency.getMonth(),field4.getText(), agent);
            display.setText("Property Rented.");
        }
        else
        {
            display.setText("Request Denied") ;
        }   
      }
      
        private int AgentId()
        {
            return Integer.parseInt(field2.getText());   
        }
        
        private int PropertyId()
        {
           return Integer.parseInt(field.getText());   
        }
        
        public void update()
        {
            field3.setText("");
            field4.setText("");
        }
        
        
        private class FindListener implements ActionListener
    {   
         public void actionPerformed(ActionEvent e)
        {   
          findId();
        }
    }
    
        private class SellListener implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
        {
          sell();
        }
}
     
        private class RentListener implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
        {
            rent();
        }
    }
    
}