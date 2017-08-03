/**
 * Author: Jaskaran Rangar
 * Last updated: 12/06/2016
 * Decryption: Scrambles the alphabet, special characters and number, and puts them in arrays,
 *            which are used to encrypt and decrypt
 * Contstructor List:
 *     Alphabets()
 *     Alphabets(int, int, int, int, int, int, int ,int, int)
 * 
 * Method List:
 *     char[] scrambler (char [], int)
 *     char[] getSample ()
 *     char[] getC1()
 *     char[] getC2()
 *     char[] getC3()
 *     char[] getC4()
 *     char[] getC5()
 *     char[] getC6()
 *     char[] getC7()
 *     char[] getC8()
 *     char[] getC9()
 *     char[] pickSequence(int, int, int)
 *     char getChar (char[], int)
 *     String getScrambleNumber ()
 * 
 * // Message: Talked to you about replacing sort method with a method that scrambles the array
 */
public class Alphabets {
  // private data
  private char[] sample, c1, c2, c3, c4, c5, c6, c7, c8, c9;
  private String scrambleNumber;
  
  // default constructor
  public Alphabets() { 
    sample = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    c1 = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    c2 = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    c3 = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    c4 = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    c5 = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    c6 = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    c7 = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    c8 = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    c9 = "abcdefghijklmnopqrstuvwxyz".toCharArray();
  }
  
  // Constructor creates nine scrammbled char array
  public Alphabets(int i, int j, int k, int l, int m, int n, int o, int p, int q)
  {
    sample = "abcdefghijklmnopqrstuvwxyz.,'?!1234567890".toCharArray();
    c1 = scrambler("abcdefghijklmnopqrstuvwxyz.,'?!1234567890".toCharArray(), i);
    c2 = scrambler("abcdefghijklmnopqrstuvwxyz.,'?!1234567890".toCharArray(), j);
    c3 = scrambler("abcdefghijklmnopqrstuvwxyz.,'?!1234567890".toCharArray(), k);
    c4 = scrambler("abcdefghijklmnopqrstuvwxyz.,'?!1234567890".toCharArray(), l);
    c5 = scrambler("abcdefghijklmnopqrstuvwxyz.,'?!1234567890".toCharArray(), m);
    c6 = scrambler("abcdefghijklmnopqrstuvwxyz.,'?!1234567890".toCharArray(), n);
    c7 = scrambler("abcdefghijklmnopqrstuvwxyz.,'?!1234567890".toCharArray(), o);
    c8 = scrambler("abcdefghijklmnopqrstuvwxyz.,'?!1234567890".toCharArray(), p);
    c9 = scrambler("abcdefghijklmnopqrstuvwxyz.,'?!1234567890".toCharArray(), q);
    scrambleNumber = i + "," + j + "," + k + "," + l + "," + m + "," + n + "," + o + "," + p + "," + q;
  }
  
  // Scrambles the input array
  public char[] scrambler (char[] a, int change)
  {
    int counter = 0;
    // goes through the array
    for (int i = 0; i< 41;i++)
    {
      //if counter is even
      if(counter%2 == 0)
      {
        //stores characters
        char helper = a[i];
        // Swaps characters that are separated by the integer value of change 
        // (if current possition + change is greater than 40)
        if (i+change > 40)
        {
          int newletter = i+change-40;
          a[i] = a[newletter];
          a[newletter] = helper;
        }
        // Swaps characters that are separated by the integer value of change
        // (if current possition + change is less than or equal 40)
        else
        {
          a[i] = a[i + change];
          a[i + change] = helper;
        }
      }
      // if counter is odd
      else
      {
        //stores characters
        char helper = a[i];
        
        // Swaps characters that are separated by the integer value of change 
        // (if current possition + change is greater than 40)
        if (i+change+1 > 40)
        {
          int newletter = i+change+1 -40;
          a[i] = a[newletter];
          a[newletter] = helper;
        }
        
        // Swaps characters that are separated by the integer value of change
        // (if current possition + change is less than or equal 40)
        else
        {
          a[i] = a[i + change + 1];
          a[i + change + 1] = helper;
        }
      }
      counter++;
    }
    
    return a;
  }
  
  //returns sample array
  public char[] getSample ()
  {
    return this.sample;
  }
  
  //returns c1
  public char[] getC1()
  {
    return this.c1;
  }
  
  //returns c2
  public char[] getC2()
  {
    return this.c2;
  }
  
  //returns c3
  public char[] getC3()
  {
    return this.c3;
  }
  
  //returns c4
  public char[] getC4()
  {
    return this.c4;
  }
  
  //returns c5
  public char[] getC5()
  {
    return this.c5;
  }
  
  //returns c6
  public char[] getC6()
  {
    return this.c6;
  }
  
  //returns c7
  public char[] getC7()
  {
    return this.c7;
  }
  
  //returns c8
  public char[] getC8()
  {
    return this.c8;
  }
  
  //returns c9
  public char[] getC9()
  {
    return this.c9;
  }
  
  // returns appropriate
  public char[] pickSequence (int i, int j, int k)
  {
    //returns c1
    if ((i == 1)&&(j == 1)&&(k == 1))
    {
      return this.c1;
    }
    
    //returns c2
    else if ((i == 1)&&(j == 1)&&(k == 2))
    {
      return this.c2;
    }
    
    //returns c3
    else if ((i == 1)&&(j == 1)&&(k == 3))
    {
      return this.c3;
    }
    
    //returns c4
    else if ((i == 1)&&(j == 2)&&(k == 1))
    {
      return this.c4;
    }
    
    //returns c5
    else if ((i == 1)&&(j == 2)&&(k == 2))
    {
      return this.c5;
    }
    
    //returns c6
    else if ((i == 1)&&(j == 2)&&(k == 3))
    {
      return this.c6;
    }
    
    //returns c7
    else if ((i == 1)&&(j == 3)&&(k == 1))
    {
      return this.c7;
    }
    
    //returns c8
    else if ((i == 1)&&(j == 3)&&(k == 2))
    {
      return this.c8;
    }
    
    //returns c9
    else
    {
      return this.c9;
    }
  }
  
  // returns character based on given char array and location
  public char getChar (char [] c, int location)
  {
    return c[location];
  }
  
  // returns nine digit key
  public String getScrambleNumber ()
  {
    return this.scrambleNumber;
  }
  
  public static void main(String[] args) { 
    char alpha[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    for (int i = 0; i<26;i++)
    {
      System.out.print(alpha[i]);
    }
    
    Alphabets a = new Alphabets(1,2,3,4,5,6,7,30,9);
    System.out.println();
    System.out.println(a.getSample());
    System.out.println(a.getC1());
    System.out.println(a.getC2());
    System.out.println(a.getC3());
    System.out.println(a.getC4());
    System.out.println(a.getC5());
    System.out.println(a.getC6());
    System.out.println(a.getC7());
    System.out.println(a.getC8());
    System.out.println(a.getC9());
    System.out.println(a.getChar(a.getC9(), 5));
    System.out.println(a.getScrambleNumber());
                       
    int counter = 1;
    for (int i = 1; i < 2;i++)
    {
      for (int j = 1; j <= 3; j++)
      {
        for (int k = 1; k <= 3; k++)
        {
          System.out.print ("c" + counter + " is ");
          System.out.println (a.pickSequence(i, j, k));
          counter++;
        }
      }
    }
  }  
}
