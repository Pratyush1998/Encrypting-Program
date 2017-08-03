/**
  * Author:Jaskaran Rangar
  * 
  * Constructor:
  * Picture()
  * Picture(ImageIcon)
  * Picture(String)
  * Picture(boolean, String, boolean, String, int, int, int)
  * 
  * Method List:
  * void paint(Graphics g)
  * void changeImage (String)
  * void changeImage(String, int, int)
  * void replaceImagetoText (String)
  * void replaceImagetoText (String, int, int)
  * void resetColor(Color)
  * void resetColor(int, int, int)
 */
import java.awt.*;
import javax.swing.*;
public class Picture extends JComponent {
  // Instance variable
  
  private Color c;
  private ImageIcon img;
  private boolean paintImg;
  private boolean displayText;
  private String txt;
  private int xCord;
  private int yCord;
  private boolean selfCord;
  private int offset;
  
  
  // default constructor
  public Picture() { 
    this.c = Color.RED;
    this.img = null;
    paintImg = false;
    this.displayText = false;
    repaint();
  }
  
  public Picture(ImageIcon i)
  {
    this.c = Color.RED;
    this.img = i;
    paintImg = true;
    repaint();
  }
  
  public Picture(String s)
  {
    this.c = Color.BLACK;
    this.img = null;
    this.txt = s;
    paintImg = false;
    displayText = true;
    repaint();
  }
  
  public Picture (boolean imgDisplay, String file, boolean textDisplay, String s, int x, int y, int off)
  {
    this.c = Color.RED;
    this.img = new ImageIcon(file);
    this.txt = s;
    paintImg = imgDisplay;
    displayText = textDisplay;
    this.xCord = x;
    this.yCord = y;
    this.offset = off;
    selfCord = true;
    repaint();
  }
  
  public void paint (Graphics g)
  {
    if (this.selfCord)
    {
      if ((this.paintImg)&&(this.displayText))
      {
        g.drawString(this.txt, this.xCord, this.yCord);
        img.paintIcon(this, g, this.xCord, this.yCord + this.offset);
      }
      else if (this.paintImg)
      {
        img.paintIcon(this, g, this.xCord, this.yCord);
      }
      
      else if (this.displayText)
      {
        Font largeFont = new Font("Comic Sans MS",Font.PLAIN,40);
        g.setFont (largeFont);
        g.drawString(this.txt, this.xCord, this.yCord);
      }
      
      else
      {
        g.setColor(this.c);
        g.drawRect(this.xCord, this.yCord, 200, 50);
        g.drawOval(this.xCord, this.yCord, 200, 50);
        g.fillOval(this.xCord + 80, this.yCord, 40, 50);
      }
    }
    
    else 
    {
      if (this.paintImg)
      {
        img.paintIcon(this, g, 0, 0);
      }
      
      else if (this.displayText)
      {
        
        g.drawString(this.txt, 100, 10);
      }
      
      else
      {
        g.setColor(this.c);
        g.drawRect(100, 10, 200, 50);
        g.drawOval(100, 10, 200, 50);
        g.fillOval(180, 10, 40, 50);
      }
    }
  }
  
  public void changeImage(String s)
  {
    this.img = new ImageIcon(s);
    repaint();
  }
  
  public void changeImage(String s, int x, int y)
  {
    paintImg = true;
    displayText = false;
    selfCord = true;
    this.txt = "";
    this.xCord = x;
    this.yCord = y;
    this.img = new ImageIcon(s);
    repaint();
  }
  
  public void replaceImagetoTitle(String s)
  {
    paintImg = false;
    this.img = null;
    this.txt = s;
    repaint();
  }
  
  public void replaceImagetoTitle(String s, int x, int y)
  {
    paintImg = false;
    displayText = true;
    selfCord = true;
    this.img = null;
    this.txt = s;
    this.xCord = x;
    this.yCord = y;
    repaint();
  }
  
  public void resetColor(Color col)
  {
    this.c = col;
    repaint();
  }
  
  public void resetColor (int r, int g, int b)
  {
    this.c = new Color(r, g, b);
    repaint();
  }
  
  //Self Testing.
  public static void main(String[] args)
  { 
    JFrame frame = new JFrame();
    Picture pic = new Picture ();
    
    frame.setSize(400, 500);
    frame.add(pic);
    frame.setVisible(true);
    JOptionPane.showMessageDialog(null, "Press ok");
    pic.resetColor(Color.BLUE);
    JOptionPane.showMessageDialog(null, "Press ok");
    pic.resetColor(128, 128, 0);
    JOptionPane.showMessageDialog(null, "Press ok");
    
    frame.remove(pic);
    JOptionPane.showMessageDialog(null, "Press ok");
    Picture pic1 = new Picture (new ImageIcon("Duck.gif"));
    frame.add(pic1);
    frame.setVisible(true);
    JOptionPane.showMessageDialog(null, "Press ok");
    pic1.changeImage("shallnotpassgig.gif");
    frame.add(pic1);
    frame.setVisible(true);
    
    pic1.changeImage("SUV.jpg", 150, 10);
    
    JOptionPane.showMessageDialog(null, "Press ok");
    frame.remove(pic1);
    Picture text = new Picture ("I am Batman");
    frame.add(text);
    frame.setVisible(true);
    
    JOptionPane.showMessageDialog(null, "Press ok");
    frame.remove(text);
    int xCord = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the x co-ordinate")); 
    int yCord = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the y co-ordinate"));
    Picture pic2 = new Picture (true, "shallnotpassgig.gif", false, "", xCord, yCord, 0);
    frame.add(pic2);
    frame.setVisible(true);
    
    JOptionPane.showMessageDialog(null, "Press ok");
    frame.remove(pic2);
    xCord = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the x co-ordinate")); 
    yCord = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the y co-ordinate"));
    Picture pic3 = new Picture (true, "shallnotpassgig.gif", true, "I am Batman!!!!!!!!", xCord, yCord , 0);
    frame.add(pic3);
    frame.setVisible(true);
    JOptionPane.showMessageDialog(null, "Press ok");
    pic3.replaceImagetoTitle("I'm Batman");
    
    JOptionPane.showMessageDialog(null, "Press ok");
    frame.remove(pic3);
    xCord = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the x co-ordinate")); 
    yCord = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the y co-ordinate"));
    pic3 = new Picture (true, "car.jpg", false, "", xCord, yCord, 0);
    frame.add(pic3);
    frame.setVisible(true);
    pic3.replaceImagetoTitle("pokemon GO", 200, 30);
  }  
}
