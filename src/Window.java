import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;


public class Window extends JFrame
{
    
    private final int WIDTH = 400, HEIGHT = 400;
    private final int LWIDTH = 200, LHEIGHT = 200;
    private Agency agency;
  
    public Window(Agency agency)
    {
        super("Derelict Real Estate");
        this.agency = agency;
        setup();
        build(agency);
        setVisible(true);   
    }
    
    private void setup()
    {   
        setSize(WIDTH, HEIGHT);
        setLocation(LWIDTH, LHEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void build(Agency agency)
    {
      add(new TabsWindow(agency));
    }

    public class TabsWindow extends JTabbedPane 
    {   
        private Agency agency;
        
        public TabsWindow(Agency agency)    
        {
            this.agency = agency;
            setup();        
            build();        
            setVisible(true);    
        }    
    
        private void setup()    
        {   
        }    
    
        private void build()    
        {        
            add("Add", new AddTabber(agency));     
            add("Run", new RunTabber(agency));    
           
        }    
    }
    
}
