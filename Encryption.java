/**
 * Author: Jaskaran Rangar
 * Last Updated: 12/06/2016
 * Descryption: Encrypts the message based on two keys
 * Constructor List:
 *     Encryption()
 *     Encryption(int, int, int, int, int, int, int, int ,int)
 *     Encryption(int, int, int, int, int, int, int, int ,int, String)
 * Method List:
 *     char encrypt(char)
 *     char encrypt(char, int, int, int)
 *     String encryptKey(String)
 *     Char [] getPhrase()
 *     String forLoop (int, int, int)
 */
public class Encryption extends Alphabets{
  
  char [] phrase;
  
  //Default Constructor
  public Encryption() { 
    super();
  }
  
  // Constructor inherits from alphabets and generates scrammbled arrays using the nine digit encryption key
  public Encryption(int i, int j, int k, int l, int m, int n, int o, int p, int q) 
  { 
    super(i,j,k,l,m,n,o,p,q);
  }
  
  // Constructor inherits from alphabets and generates scrammbled arrays using the nine digit encryption key and 
  //make the sentence to be decrypted into a char array
  public Encryption(int i, int j, int k, int l, int m, int n, int o, int p, int q, String forPhrase) 
  { 
    super(i,j,k,l,m,n,o,p,q);
    phrase = forPhrase.toCharArray();
  }
  
  // Basic encrypter
  public char encrypt (char c)
  {
    char newletter;
    int location;
    //Searches through the sample array for the input character
    location = ArrayLibrary.searchletter(this.getSample(), Character.toLowerCase(c));
    // If character is present in the sample array
    if (location >= 0)
    {
      // gets the encrypted character by corresponding location in the first scrammbled array
      newletter = this.getChar(super.getC1(), location);
      return newletter;
    }
    // If Character is not found
    else 
    {
      return c;
    }
  }
  
  // Encrypts that uses the nine array combination
  public char encrypt (char c, int i, int j, int k)
  {
    char newletter;
    int location;
    //Searches through the sample for the input character
    location = ArrayLibrary.searchletter(this.getSample(), Character.toLowerCase(c));
    if (location >= 0)
    {
      // gets the encrypted character by corresponding location in the appropriate array
      newletter = this.getChar(this.pickSequence(i, j, k), location);
      return newletter;
    }
    // If Character is not found
    else 
    {
      return c;
    }
  }
  
  //Encrypts keys
  public String encryptKey (String c)
  {
    // separates double digit key
    char [] numbers = c.toCharArray();
    String binaryStrings = "";
    for (int i = 0; i < numbers.length; i++)
    {
      // gets ascii code for character
      int encrypt = (int)numbers[i];
      // Used to change ascii code (Security purposes)
      encrypt = encrypt - 10;
      // Converts ascii into binary
      String binaryString = Integer.toBinaryString(encrypt);
      // Stores binary first digit
      if (i == 0)
      {
        binaryStrings = binaryString;
      }
      //separates binary for 2 digits
      else 
      {
        binaryStrings = binaryStrings + " " + binaryString;
      }
    }
    return binaryStrings;
  }
  
  // Returns the phrase to be encrypted in form of char array
  public char [] getPhrase ()
  {
    return this.phrase;
  }
  
  //Encrypts the phrase
  public String forLoop (int w, int x, int y)
  {
    // gets phrase to encrypt
    char [] v = this.phrase;
    // Stores the encrypted phrase
    String sentence = "";
    // counter to check the length of encrypted phrase
    int count =0;
    
    // Sets initial value to the encrypter and encrypts
    for (int i = w; i < 2; i++)
    {
      for (int j = x; j <=3; j++)
      {
        for (int k = y; k <= 3; k++)
        {
          
          // encrypts if there are charactes to decrypt
          if (count < v.length)
          {
            sentence = sentence + this.encrypt(v[count], i, j, k);
            count++;
          }
          
          // If the setting reach max and there are still characters to encrypt. Resets the settings
          if ((w==1)&&(j==3)&&(k==3)&&(count < v.length))
          {
            i = w = 1;
            j = x = 1;
            k = y = 0;
          }
          
          // When phrase is encrypted
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
  //Self Testing
  public static void main(String[] args) { 
    Encryption e = new Encryption (1,2,3,4,5,6,7,8,9);
    Encryption en = new Encryption ();
    Encryption enc = new Encryption (1,2,3,4,5,6,7,8,9, "I'm Batman");
    for (int i = 0; i < enc.getPhrase().length; i++)
    {
      System.out.println(enc.getPhrase()[i]);
    }
    System.out.println(e.encrypt('o'));
    System.out.println(e.encrypt('2', 1, 2, 3));
    System.out.println(e.encryptKey("2"));
    System.out.println(enc.forLoop(1,2,3));
  }  
}
