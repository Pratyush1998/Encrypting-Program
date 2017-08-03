/**
 * Author: Pratyush Bhandari
 * Last Updated: 12/06/2016
 * Descryption: Decrypts the message based on two keys
 * Constructor List:
 *     Decryption()
 *     Decryption(int, int, int, int, int, int, int, int ,int)
 *     Decryption(int, int, int, int, int, int, int, int ,int, String)
 * Method List:
 *     char decrypt(char)
 *     char decrypt(char, int, int, int)
 *     String decryptKey(String)
 *     Char [] getPhrase()
 *     String decryptforLoop (int, int, int)
 */
public class Decryption extends Alphabets{
  
  char[] phrase;
  
  //Default Constructor
  public Decryption() { 
    super();
  }
  
  // Constructor inherits from alphabets and replicates the nine digit encryption key
  public Decryption(int i, int j, int k, int l, int m, int n, int o, int p, int q) 
  { 
    super(i,j,k,l,m,n,o,p,q);
  }
  
  // Constructor inherits from alphabets and replicates the nine digit encryption key and make the sentence to be decrypted into a char array
  public Decryption(int i, int j, int k, int l, int m, int n, int o, int p, int q, String forPhrase) 
  { 
    super(i,j,k,l,m,n,o,p,q);
    phrase = forPhrase.toCharArray();
  }
  
  // Basic decrypter
  public char decrypt (char c)
  {
    char newletter;
    int location;
    //Searches through the first scrammbled array for the input character
    location = ArrayLibrary.searchletter(super.getC1(), Character.toLowerCase(c));
    // If character is present in the scrammbled array
    if (location >= 0)
    {
      // gets the original character by corresponding location in the sample array
      newletter = this.getChar(this.getSample(), location);
      return newletter;
    }
    // If Character is not found
    else 
    {
      return c;
    }
  }
  
  // Decrypter that uses the nine array combination
  public char decrypt (char c, int i, int j, int k)
  {
    char newletter;
    int location;
    //Searches through the appropriate scrammbled array for the input character
    location = ArrayLibrary.searchletter(this.pickSequence(i, j, k), Character.toLowerCase(c));
    if (location >= 0)
    {
      // gets the original character by corresponding location in the sample array
      newletter = this.getChar(this.getSample(), location);
      return newletter;
    }
    // If Character is not found
    else 
    {
      return c;
    }
  }
  
  // Decrypts the encrypted keys
  public String decryptKey (String binary)
  {
    // Splits the key (necessary if the key was double digits)
    String [] binarys = binary.split(" ");
    String holder = "";
    for (int i = 0; i < binarys.length;i++)
    {
      //converts binary into ascii code
      int ascii = Integer.parseInt(binarys[i], 2);
      // Reverse of encryption
      ascii = ascii + 10;
      //gets character from ascii code
      char c = (char)ascii;
      // gets integer value of character
      int num = Character.getNumericValue((char)ascii);
      // Makes it double digit if it was like that originally
      holder = holder + num;
    }
    return holder;
  }
  
  // Returns the phrase to be decrypted in form of char array
  public char[] getPhrase()
  {
    return this.phrase;
  }
  
  // Decrypts the phrase
  public String decryptforLoop (int w, int x, int y)
  {
    // gets phrase to decrypt
    char [] v = this.getPhrase();
    // Stores the decrypted phrase
    String sentence = "";
    // counter to check the length of decrypted phrase
    int count = 0;
    
    // Sets initial value to the decrypter and decrypts
    for (int i = w; i < 2; i++)
    {
      for (int j = x; j <=3; j++)
      {
        for (int k = y; k <= 3; k++)
        {
          // Decrypts if there are charactes to decrypt
          if (count < v.length)
          {
            sentence = sentence + this.decrypt(v[count], i, j, k);
            count++;
          }
          
          // If the setting reach max and there are still characters to decrypt. Resets the settings
          if ((w==1)&&(j==3)&&(k==3)&&(count < v.length))
          {
            i = w = 1;
            j = x = 1;
            k = y = 0;
          }
          // When phrase is decrypted
          if (count == v.length)
          {
            break;
          }
          // If original y setting is not 1 and k has reached 3
          if ((k == 3) && (y != 1))
          {
            y = 1;
          }
        }
      }
    }
    
    return sentence;
  }
  
  // self Testing
  public static void main(String[] args) { 
    Decryption d = new Decryption (1,2,3,4,5,6,7,8,9);
    Decryption de = new Decryption ();
    Decryption dec = new Decryption (1,2,3,4,5,6,7,8,9, "hul 0cxlfu");
    for (int i = 0; i < dec.getPhrase().length; i++)
    {
      System.out.println(dec.getPhrase()[i]);
    }
    System.out.println(d.decrypt('m'));
    System.out.println(d.decrypt('1', 1, 2, 3));
    System.out.println(d.decryptKey("101000"));
    System.out.println(dec.decryptforLoop(1,2,3));
  }  
}
