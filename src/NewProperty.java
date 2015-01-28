import model.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

 public class NewProperty extends JPanel implements MyObserver
    {
        private String[] type={"Sale","Rental"};
        private JLabel label = new JLabel("New Property");
        private JTextField field = new JTextField(8);
        private JTextField field2 = new JTextField(8);
        private JLabel label4 = new JLabel("Type: ");
        private JComboBox box = new JComboBox(type);
        private JButton add = new JButton("Add");
        private JLabel display = new JLabel();
        private Agency agency;
        
        public NewProperty(Agency agency)
        {        
            this.agency = agency;
            setup();
            build();
        }
        
        private void setup()
        {
            label.setForeground(Color.pink);
            setBorder(BorderFactory.createLineBorder(Color.blue));
            add.addActionListener(new AddPropertyListener());
            agency.getProperties().attach(this);
        }
        
        private void build()
        {
            add(label);
            addPair("Owner : ",field);
            addPair("Price : $",field2);
            add(label4);
            add(box);
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
            field2.setText("");
        }
        
        public void addProperty()
        {
            Properties properties = agency.getProperties(); 
            String type = (String)box.getSelectedItem();
            String owner = field.getText();
              
            if (type.equals("Sale"))
            {
                properties.addSale(price(),owner);   
            }
            
             else if (type.equals("Rental"))
            {
                properties.addRental(price(),owner);
            }
                display.setText(type +" property is added.");
        }
        
        public double price()
        {      
            return Double.parseDouble(field2.getText());
        }
         
        private class AddPropertyListener implements ActionListener
    {   
               public void actionPerformed(ActionEvent e)
          {   
                addProperty();
          }
        
    }
}