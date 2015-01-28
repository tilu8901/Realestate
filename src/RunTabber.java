import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import model.*;

public class RunTabber extends JPanel
{

        private Agency agency;
        Property pane;
        Report pane2;
        Summary pane3;
        
        public RunTabber(Agency agency)
        {        
            this.agency = agency;
            pane = new Property(agency);
            pane2 = new Report(agency);
            pane3 = new Summary(agency);
            setup();
            build();
        }
        
        private void setup()
        {
            setLayout(new GridLayout(3, 0));
        }
        
        private void build()
        {
           add(pane);
           add(pane2);
           add(pane3);
        }
        
}
        

    
    
