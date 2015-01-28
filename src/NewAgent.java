import model.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


 public class NewAgent extends JPanel implements MyObserver
    {
        private JLabel label = new JLabel("New Agent");
        private JTextField field = new JTextField(10);
        private JButton add = new JButton("Add");
        private JLabel display = new JLabel();
        private Agency agency;
        
        public NewAgent(Agency agency)
        {      
            this.agency = agency;
            setup();
            build();
        }
        
        private void setup()
        {
            label.setForeground(Color.pink);
            setBorder(BorderFactory.createLineBorder(Color.blue));
            add.addActionListener(new NewAgentListener());
            agency.getAgents().attach(this);
        }
        
        private void build()
        {
            add(label);
            addPair("Name :",field);
            add(add);
            add(display);
        }
        
         private void addPair(String label, JTextField field)
        { 
            add(new JLabel(label));
            add(field);    
        }
        
        public void update()
        {
            field.setText("");
        }
        
        public void newAgent()
        {
            Agents agents = agency.getAgents();
            agents.add(field.getText());
            display.setText(field.getText() +" is added.");
        }
        
        private class NewAgentListener implements ActionListener
    {   
      public void actionPerformed(ActionEvent e)
        {   
            newAgent();
        }
    }
}