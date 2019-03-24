import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.*;
import javax.swing.text.Highlighter.HighlightPainter;

/*
 *  Implements a simple highlight painter that renders a rectangle around the
 *  area to be highlighted.
 *
 */
public class SquigglePainter extends DefaultHighlighter.DefaultHighlightPainter
{
        
        int k0=1;
        JTextArea text=null;
        Object h=null;
        
	public SquigglePainter(Color color)
	{
		super( color );
	}

	/**
	 * Paints a portion of a highlight.
	 *
	 * @param  g the graphics context
	 * @param  offs0 the starting model offset >= 0
	 * @param  offs1 the ending model offset >= offs1
	 * @param  bounds the bounding box of the view, which is not
	 *	       necessarily the region to paint.
	 * @param  c the editor
	 * @param  view View painting for
	 * @return region drawing occurred in
	 */
        public static void main(String args[])
        {
            SquigglePainter obj=new SquigglePainter(Color.RED);
            obj.getToIt();
        }
        public class Listener0 implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                try {
                    SquigglePainter obj=new SquigglePainter(Color.RED);
                    //if(k==0)
                    //{
                        text.getHighlighter().addHighlight(5, 9, obj);
                        //k++;
                    //}
                } catch (BadLocationException ex) {
                Logger.getLogger(SquigglePainter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        void check(Trie x,String k,int a,int b,HighlightPainter painter,ArrayList al)
        {
            //Object h=null;
            int p=1;
            
            if(!x.search(k))
            {
                p=0;
                System.out.println(k+" not found");
                Font font = new Font("Verdana", Font.BOLD, 12);
                
                text.setFont(font);
                text.setForeground(Color.BLUE);
                
                    /*try { 
                        //if(h==null)
                        al.add(a);
                        al.add(b);
                        if(h!=null)
                        text.getHighlighter().removeHighlight(h);
                        h=text.getHighlighter().addHighlight(a,b,painter);
                        //text.getHighlighter().removeHighlight(h);
                    } catch (BadLocationException ex) {
                    Logger.getLogger(SquigglePainter.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                }
            /*if(p==1)
            {
                if(h!=null)
                {
                    text.getHighlighter().removeHighlight(h);
                    h=null;
                }
                System.out.println(k+" found"); 
            }*/
            else
                 System.out.println(k+" found"); 
        }
        public void getToIt()
        {
            
            Trie trying=new Trie();
            trying.insert("good");
            SquigglePainter obj=new SquigglePainter(Color.RED);
            text=new JTextArea(10,20);
            ArrayList<Integer> al=new ArrayList<>();
            Highlighter highlighter = text.getHighlighter();
        HighlightPainter painter = 
             new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
            text.setBackground(Color.green);
            int i,start=0;
            JFrame frame=new JFrame();
            text.addKeyListener(new KeyListener(){ 

    public void keyPressed(KeyEvent ke){ 
         if(ke.getKeyCode()==KeyEvent.VK_SPACE){
             
             String k=text.getText().trim();
             int i=k.length()-1,l=i;
             //System.out.println(i);
             int sp=0;
             while(i>=0)
             {
                 if(k.charAt(i)==' ')
                     sp++;
                 if(sp==1)
                 {
                     check(trying,k.substring(i).trim(),i,l,painter,al);
                     //al.add(i);
                     //al.add(l);
                     break;
                 }
                 i--;
             }
             //System.out.println(sp);
             if(sp==0)
             {
                 //al.add(i);
                 //al.add(l);
                 check(trying,k.trim(),i,l,painter,al);
             }
               }
         }
                @Override
                public void keyTyped(KeyEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                @Override
                public void keyReleased(KeyEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400,400);
            frame.add(text);
            JButton button=new JButton();
            JPanel panel=new JPanel();
             JPanel panel2=new JPanel();
            //panel2.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            //panel.add( button);
            frame.getContentPane().add(BorderLayout.EAST,button);  
            frame.getContentPane().add(BorderLayout.NORTH,text);
            button.addActionListener(new Listener0()); 
            frame.setVisible(true);
            
            
        }
	public Shape paintLayer(Graphics g, int offs0, int offs1, Shape bounds, JTextComponent c, View view)
	{
		Rectangle r = getDrawingArea(offs0, offs1, bounds, view);

		if (r == null) return null;

		//  Do your custom painting

		Color color = getColor();
		g.setColor(color == null ? c.getSelectionColor() : color);

		//  Draw the squiggles

		int squiggle = 2;
		int twoSquiggles = squiggle * 2;
		int y = r.y + r.height - squiggle;

        for (int x = r.x; x <= r.x + r.width - twoSquiggles; x += twoSquiggles)
        {
            g.drawArc(x, y, squiggle, squiggle, 0, 180);
            g.drawArc(x + squiggle, y, squiggle, squiggle, 180, 181);
        }

		// Return the drawing area

		return r;
	}


	private Rectangle getDrawingArea(int offs0, int offs1, Shape bounds, View view)
	{
		// Contained in view, can just use bounds.

		if (offs0 == view.getStartOffset() && offs1 == view.getEndOffset())
		{
			Rectangle alloc;

			if (bounds instanceof Rectangle)
			{
				alloc = (Rectangle)bounds;
			}
			else
			{
				alloc = bounds.getBounds();
			}

			return alloc;
		}
		else
		{
			// Should only render part of View.
			try
			{
				// --- determine locations ---
				Shape shape = view.modelToView(offs0, Position.Bias.Forward, offs1,Position.Bias.Backward, bounds);
				Rectangle r = (shape instanceof Rectangle) ? (Rectangle)shape : shape.getBounds();

				return r;
			}
			catch (BadLocationException e)
			{
				// can't render
			}
		}

		// Can't render

		return null;
	}
}