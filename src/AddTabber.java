import model.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AddTabber extends JPanel
{
    Agency agency;
    NewAgent pane;
    NewProperty pane2;
    
    public AddTabber(Agency agency)
    {   
        this.agency = agency;
        pane = new NewAgent(agency);
        pane2 = new NewProperty(agency);
        setup();
        build();
    }
    
    private void setup()
    {
        setLayout(new GridLayout(2, 0));
    }
    
    private void build()
    {
        add(pane);
        add(pane2);
    }
    
    
        
}
       

    
    
