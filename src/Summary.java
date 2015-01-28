import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import model.*;
import java.util.*;

 public class Summary extends JPanel implements MyObserver
    {
        private JLabel label = new JLabel("Summary ");
        private JLabel label2 = new JLabel("Month ");
        private JTextField field = new JTextField(8);
        private JLabel label3 = new JLabel(" Income ");
        private JTextField field2 = new JTextField(8);
        private JLabel label4 = new JLabel(" Balance ");
        private JTextField field3 = new JTextField(5);
        private JButton endmonth = new JButton("End Month");
        private JButton exit = new JButton("Exit");
        private JButton show = new JButton("Show");
        private Agency agency;
        
        
        public Summary(Agency agency)
        {   
            this.agency=agency;
            setup(agency);
            build();
        }
        
        private void setup(Agency agency)
        {
            label.setForeground(Color.pink);
            setBorder(BorderFactory.createLineBorder(Color.blue));
            endmonth.addActionListener(new EndmonthListener());
            exit.addActionListener(new ExitListener());
            show.addActionListener(new ShowListener());
            this.agency=agency;
            agency.attach(this);
            agency.getProperties().attach(this);
            Iterator<Record> propertyit = agency.getProperties().records().iterator();
            while (propertyit.hasNext())
			propertyit.next().attach(this);
			agency.getAgents().attach(this);
			Iterator<Record> agentit = agency.getAgents().records().iterator();
		    while (agentit.hasNext())
			agentit.next().attach(this);
         }
        
         private void build()
        {
           add(label);
           add(label2);
           add(field);
           add(label3);
           add(field2);
           add(label4);
           add(field3);
           add(endmonth);
           add(exit);
           add(show);
        }
        
        public void update()
        {
            field.setText(Integer.toString(agency.getMonth()));
            field2.setText(Double.toString(agency.income()));
            field3.setText(Double.toString(agency.getBalance()));
        }
        
        private class EndmonthListener implements ActionListener
    {   
       public void actionPerformed(ActionEvent e)
        {   
            agency.endMonth();
        }
    }   
        
        private class ExitListener implements ActionListener
    {   
       public void actionPerformed(ActionEvent e)
        {   
             System.exit(0);
        }
    }
    
        private class ShowListener implements ActionListener
    {   
       public void actionPerformed(ActionEvent e)
        {   
           agency.show();
        }
    }
    
}