import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import model.*;

 public class Report extends JPanel
    {
        private Agency agency;
        private JLabel label = new JLabel("Derelict Report");
        private JButton report = new JButton("View Report");
        
        public Report(Agency agency)
        {        
            this.agency=agency;
            setup();
            build();
        }
        
        private void setup()
        {
            label.setForeground(Color.pink);
            setBorder(BorderFactory.createLineBorder(Color.blue));
            report.addActionListener(new ReportListener());
        }
        
        private void build()
        {
           add(label);
           add(report);
        }
        
            private class ReportListener implements ActionListener
    {   
        public void actionPerformed(ActionEvent e)
        {   
            agency.showReport();
        }
    }
        
    }