/**
 * Integrated Testing
 */
import javax.swing.*;
public class Test {
  
  public Test() { 
    /* YOUR CONSTRUCTOR CODE HERE*/
  }
  
  public static void main(String[] args) { 
    
    Encryption enc = new Encryption (1,2,3,4,5,6,7,8,9);
    Decryption dec = new Decryption (1,2,3,4,5,6,7,8,9);
    String toCode = JOptionPane.showInputDialog(null, "Message to encrypt");
    char [] v = toCode.toCharArray();
    String sentence = "";
    int w, x, y, count;
    int counter = 0;
    w = 1;
    x = 3;
    y = 2;
    count = 0;
    
    for (int i = w; i < 2; i++)
    {
      for (int j = x; j <=3; j++)
      {
        for (int k = y; k <= 3; k++)
        {
          
          if (count < v.length)
          {
            sentence = sentence + enc.encrypt(v[count], i, j, k);
            count++;
          }
          
          if ((w==1)&&(j==3)&&(k==3)&&(count < v.length))
          {
            i = w = 1;
            j = x = 1;
            k = y = 0;
            counter++;
          }
          
          if (count == v.length)
          {
            break;
          }
          
          if ((k == 3) && (y != 1))
          {
            y = 1;
          }
        }
      }
    }
    JOptionPane.showMessageDialog(null, sentence);
    toCode = JOptionPane.showInputDialog(null, "Message to encrypt");
    counter = 0;
    count = 0;
    w = 1;
    x = 3;
    y = 2;
    char [] n = toCode.toCharArray();
    String dsentence = "";
    for (int i = w; i < 2; i++)
    {
      for (int j = x; j <=3; j++)
      {
        for (int k = y; k <= 3; k++)
        {
          
          if (count < n.length)
          {
            dsentence = dsentence + dec.decrypt(n[count], i, j, k);
            count++;
          }
          
          if ((w==1)&&(j==3)&&(k==3)&&(count < n.length))
          {
            i = w = 1;
            j = x = 1;
            k = y = 0;
            counter++;
          }
          
          if (count == n.length)
          {
            break;
          }
          
          if ((k == 3) && (y != 1))
          {
            y = 1;
          }
        }
      }
    }
    JOptionPane.showMessageDialog(null, dsentence);
    toCode = JOptionPane.showInputDialog(null, "Message to encrypt");
    counter = 0;
    count = 0;
    w = 1;
    x = 3;
    y = 2;
    char [] a = toCode.toCharArray();
    String dsentences = "";
    for (int i = w; i < 2; i++)
    {
      for (int j = x; j <=3; j++)
      {
        for (int k = y; k <= 3; k++)
        {
          
          if (count < a.length)
          {
            dsentences = dsentences + dec.decrypt(a[count], i, j, k);
            count++;
          }
          
          if ((w==1)&&(j==3)&&(k==3)&&(count < a.length))
          {
            i = w = 1;
            j = x = 1;
            k = y = 0;
            counter++;
          }
          
          if (count == a.length)
          {
            break;
          }
          
          if ((k == 3) && (y != 1))
          {
            y = 1;
          }
        }
      }
    }
    JOptionPane.showMessageDialog(null, dsentences);
  }
  
  /* ADD YOUR CODE HERE */
  
}
