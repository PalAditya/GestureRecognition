import java.awt.AWTEvent;
import java.awt.AWTEventMulticaster;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;
import java.awt.AWTEventMulticaster;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class Pullak {
    public static void main(String args[]) throws Exception
    {
        Pullak obj=new Pullak();
        obj.go();
    }
    public void go()
    {
        JFrame f = new JFrame("Draw a Red Line");
        f.setSize(300, 300);
        f.setLocation(300, 300);
        f.setResizable(true);
        ArrayList<Point> al=new ArrayList<>();
        ArrayList<Point> cl=new ArrayList<>();
        JPanel p = new JPanel() {
            Point pointStart = null;
            Point pointEnd   = null;
            {
                
                addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        if(SwingUtilities.isRightMouseButton(e))
                        {
                            cl.add(e.getPoint());
                            
                        }
                        pointStart = e.getPoint();
                        al.add(pointStart);
                    }

                    public void mouseReleased(MouseEvent e) {
                        pointStart=null;
                        pointEnd=e.getPoint();
                        al.add(pointEnd);
                        repaint();
                    }
                });
                /*addMouseMotionListener(new MouseMotionAdapter() {
                    public void mouseMoved(MouseEvent e) {
                        pointEnd = e.getPoint();
                        if(al.size()>1)
                        al.remove(al.size()-1);
                        al.add(pointEnd);
                    }*/

                   /* public void mouseDragged(MouseEvent e) {
                        pointEnd = e.getPoint();
                        if(al.size()>1)
                        al.remove(al.size()-1);
                        al.add(pointEnd);
                        repaint();
                    }
                });*/
            }
            public void paint(Graphics g) {
                super.paint(g);
                Iterator itr=al.iterator();
                /*if (pointStart != null) {
                    g.setColor(Color.RED);
                    g.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
                }*/
                while(itr.hasNext())
                {
                    Point X=(Point)itr.next();
                    if(itr.hasNext())
                    {
                        Point Y=(Point)itr.next();
                        g.setColor(Color.RED);
                        g.drawLine(X.x, X.y, Y.x, Y.y);
                    }
                }
                Iterator itr2=cl.iterator();
                while(itr2.hasNext())
                {
                    Color c = new Color(1.0F,0.0F,1.0F);
                    g.setColor(c);
                    Point r=(Point)itr2.next();
                    g.fillOval(r.x, r.y, 50, 50);
                    //g.drawRect(r.x, r.y, 50, 50);
                }
            }
        };
        /*JButton rb = new JButton("Go");
        rb.setBounds(0, 0, 40, 30);
        rb.setBackground(Color.yellow);
        rb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(f, "You said: " + "Umm");
            }
        });*/
        f.add(p);
        //f.add(rb);
        f.setVisible(true); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /*public class RoundButton extends JButton {
  public RoundButton(String label) {
    super(label);

// These statements enlarge the button so that it 
// becomes a circle rather than an oval.
    Dimension size = getPreferredSize();
    size.width = size.height = Math.max(size.width, 
      size.height);
    setPreferredSize(size);

// This call causes the JButton not to paint 
   // the background.
// This allows us to paint a round background.
    setContentAreaFilled(false);
  }

// Paint the round background and label.
  protected void paintComponent(Graphics g) {
    if (getModel().isArmed()) {
// You might want to make the highlight color 
   // a property of the RoundButton class.
      g.setColor(Color.lightGray);
    } else {
      g.setColor(getBackground());
    }
    g.fillOval(0, 0, getSize().width-1, 
      getSize().height-1);

// This call will paint the label and the 
   // focus rectangle.
    super.paintComponent(g);
  }

// Paint the border of the button using a simple stroke.
  protected void paintBorder(Graphics g) {
    g.setColor(getForeground());
    g.drawOval(0, 0, getSize().width-1, 
      getSize().height-1);
  }

// Hit detection.
  Shape shape;
  public boolean contains(int x, int y) {
// If the button has changed size, 
   // make a new shape object.
    if (shape == null || 
      !shape.getBounds().equals(getBounds())) {
      shape = new Ellipse2D.Float(0, 0, 
        getWidth(), getHeight());
    }
    return shape.contains(x, y);
  }

    }*/
}
