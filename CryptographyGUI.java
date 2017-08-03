/*Name: Pratyush Bhandari and Jaskaran Rangar
 *Date: 6/14/2016
 *Description: This class is the grpahical user interface of the cryptography machine. 
 *             it uses objects of Encryption and Decryption to create a functioning machine
 *             that can both decrypt encrpyted text and encrypt normal text. As well as doing 
 *             this, the GUI also allows the user to read encrypted or decrypted files from his/her
 *             computer.
 *
 *Method List:
 *void fileExplorer()
 *void keyFileExplorer() 
 *void saveFileAsExplorer()
 */

//importing needed packages
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.*;

//this class inherits from JFrame and ActionListener
public class CryptographyGUI extends JFrame implements ActionListener, FocusListener
{
  //declaring all instance variables needed to construct the GUI
  private JRadioButton radEncrypt, radDecrypt;
  protected JTextField [] comboArray;
  private JTextArea inputPhrase, outputPhrase;
  private JLabel lblKey1, lblKey2, lblEncryption, lblDecryption, lblTitle;
  private ButtonGroup crypt;
  private int cryptOption;
  private String keyNumber1, keyNumber2;
  private Picture picBottom;
  private JComboBox keyList1, keyList2;
  private String [] keyArray;
  private JFileChooser fc;
  private JScrollPane scroller1, scroller2;
  private JButton btnSave, btnRead, btnTranslate, btnExit;
  
  //class constructor
  public CryptographyGUI() 
  {
    //using parent JFrame constructor
    super ("Cryptography Class");
    
    //layout set to null for maximum flexibility
    setLayout(null);
    
    //creating JLabel object named called lblTitle
    lblTitle = new JLabel ("Neo-Enigma");
    //setting font and color of JLabel
    lblTitle.setFont(new Font("ROMAN_BASELINE", Font.BOLD, 30));
    lblTitle.setForeground(Color.WHITE);
    
    //creating JLabel object named lblKey1
    lblKey1 = new JLabel("First Key!");
    //setting font and colot of JLabel
    lblKey1.setFont(new Font("Serif", Font.BOLD, 15));
    lblKey1.setForeground(Color.WHITE);
    
    //creating JLabel object named lblKey2
    lblKey2 = new JLabel("Second Key!");
    //setting font and color of JLabel 
    lblKey2.setFont(new Font("Serif", Font.BOLD, 15));
    lblKey2.setForeground(Color.WHITE);
    
    //creating JLabel object named lblEncryption
    lblEncryption = new JLabel("Input text");
    //setting font and color of JLabel
    lblEncryption.setFont(new Font("Serif", Font.BOLD, 15));
    lblEncryption.setForeground(Color.WHITE);
    
    //creating JLabel object named lblDecrpytion
    lblDecryption = new JLabel ("Output text");
    //setting font and color of JLabel
    lblDecryption.setFont(new Font("Serif", Font.BOLD, 15));
    lblDecryption.setForeground(Color.WHITE);
    
    //creating JTextArea object named inputPhrase
    //creating boundary for writing in JTextArea
    inputPhrase = new JTextArea("Enter Phrase");
    inputPhrase.setLineWrap(true);
    
    //creating an array of 4 strings called keyArray
    keyArray = new String [4];
    
    //initializing keyArray to numbers from 1 to 3
    for (int i =1; i<4; i++)
    {
      keyArray[i] = "" + i + "";
    }
    //creating 2 JComboBox objects with keyArray inputs
    keyList1= new JComboBox (keyArray);
    keyList2= new JComboBox (keyArray);
    
    try
    {
      //creating picture object named picBottom
      picBottom = new Picture(new ImageIcon(ImageIO.read(getClass().getResource("lock.jpg"))));
      //setting size and location of Picture object
      picBottom.setBounds(0,0,500,550);
    }
    
    catch (IOException error)
    {
      JOptionPane.showMessageDialog(null, "Image Not found");
    }
    
    //set staring values of keyList1 and keyList2 to 1
    keyList1.setSelectedIndex(0);
    keyList2.setSelectedIndex(0);
    
    //creating all JButton objects used in GUI
    btnTranslate = new JButton("Translate");
    btnSave = new JButton("Save");
    btnRead = new JButton ("Load");
    btnExit = new JButton ("Exit");
    
    
    //creating two radio buttons and adding them both to one ButtonGroup object named crypt
    radEncrypt = new JRadioButton("Encrypt", true);
    radDecrypt = new JRadioButton ("Decrypt", false);
    crypt = new ButtonGroup();
    crypt.add(radEncrypt);
    crypt.add(radDecrypt);
    
    //making an array of 9 JTextField objects 
    comboArray = new JTextField[9];
    
    for (int i=0; i<9; i++)
    {
      //initializing all elements of the array
      comboArray[i] = new JTextField("#");
      //setting location and size for each TextField
      comboArray[i].setBounds(50+(i*30), 150, 20, 20);
      //adding an actionListner to all textfields in array
      comboArray[i].addActionListener(this);
      
      comboArray[i].addFocusListener(this);      
      
      //adding all jtextfields to the frame
      add(comboArray[i]);
    }  
    
    //creating JTextArea object named outputPhrase
    outputPhrase = new JTextArea();
    outputPhrase.setLineWrap(true);
    //can not edit this jTextArea
    outputPhrase.setEditable(false);
    
    //making two scrollpane objects with inputPhrase and outputPhrase as
    //parameters respectively
    scroller1 = new JScrollPane(inputPhrase);
    scroller2 = new JScrollPane(outputPhrase);
    
    //seeting size and location of all object in the frmae
    lblTitle.setBounds(115, 20, 300, 50);
    lblKey1.setBounds(165, 75, 100, 20);
    lblKey2.setBounds(165, 125, 100, 20);
    lblEncryption.setBounds(165, 175, 100, 20);
    lblDecryption.setBounds(165, 350, 100, 20);
    scroller2.setBounds(20, 370, 350, 80);
    btnSave.setBounds(15, 460, 110, 40);    
    btnRead.setBounds(145, 460, 110, 40);
    btnExit.setBounds(275, 460, 110, 40);
    keyList1.setBounds(150, 100, 40, 20);
    keyList2.setBounds(200, 100, 40, 20);
    btnTranslate.setBounds(20, 280, 350, 40);
    scroller1.setBounds(20, 200, 350, 80);
    radEncrypt.setBounds(100, 320, 80, 20);
    radDecrypt.setBounds(190, 320, 80, 20);
    
    //adding all objects to the frame
    add(lblTitle);
    add(lblKey1);
    add(lblKey2);
    add(lblEncryption);
    add(lblDecryption);
    add(scroller1);
    add(scroller2);
    add(btnTranslate);
    add(radEncrypt);
    add(radDecrypt);
    add(keyList2);
    add(keyList1);
    add(btnSave);
    add(btnRead);
    add(btnExit);
    add(picBottom);
    
    //adding actionListeners to the buttons, radiobuttons and keylists in the GUI
    radEncrypt.addActionListener(rotationRadioButtonListener);
    radDecrypt.addActionListener(rotationRadioButtonListener);
    keyList1.addActionListener(this);
    keyList2.addActionListener(this);
    btnTranslate.addActionListener(this);
    btnRead.addActionListener(this);
    btnSave.addActionListener(this);
    btnExit.addActionListener(this);
    inputPhrase.addFocusListener(this);
    
    //setting size of frame
    setSize(400, 550);
    //set visible
    setVisible(true);
    //set location
    setLocation(100, 100);
    //can't resize
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
  }
  
  
  ActionListener rotationRadioButtonListener = new ActionListener()
  {
    //this action performed class is for the radioButtons
    //it automatically unselects one of the radio buttons if 
    //the other is clicked
    public void actionPerformed (ActionEvent e)
    {
      AbstractButton a = (AbstractButton)e.getSource();
      if(a==radEncrypt)
      {
        cryptOption = 0;
      }
      else if(a==radDecrypt)
      {
        cryptOption = 1;
      }
    }
  };
  
  //this actionPerformed method is used to carry out speicific actions
  //for objects that have actionListeners
  public void actionPerformed (ActionEvent e)
  {
    //if keyList1 is clicked
    if (e.getSource() == keyList1)
    {
      //sets keyNumber1 to value of the object clicked in keyList1
      JComboBox cb = (JComboBox)e.getSource();
      keyNumber1 = (String)cb.getSelectedItem();
    }
    
    //if keyList2 is clicked
    else if (e.getSource() == keyList2)
    {
      //sets keyNumber2 to value of the object clicked in keyList2
      JComboBox cb2 = (JComboBox)e.getSource();
      keyNumber2 = (String)cb2.getSelectedItem();
    }
    
    //if translate is clicked
    if (e.getSource() == btnTranslate)
    {      
      try
      {
        //if encryptRadio button is selected
        if(cryptOption == 0)
        {
          //get the text from the inputBox
          inputPhrase.getText();
          
          //creating an array of 9 numbers
          int numcomboArray [] = new int[9];
          
          //initializing the array of 9 numbers to the 9 digit key
          //entered by the user
          for (int i=0; i<9; i++)
          {
            numcomboArray[i] = Integer.parseInt(comboArray[i].getText());
          }
          
          //making an encryption object named encryptText
          Encryption encryptText = new Encryption(numcomboArray[0], numcomboArray[1],numcomboArray[2],numcomboArray[3],
                                                  numcomboArray[4], numcomboArray[5], numcomboArray[6], numcomboArray[7],
                                                  numcomboArray[8], inputPhrase.getText());
          
          //creating a string and setting it equal to the return value of the forLoop method in Encryption
          String encryptedWord = encryptText.forLoop(1, Integer.parseInt(keyNumber1), Integer.parseInt(keyNumber2));
          
          //setting output text in GUI to the encrypted phrase
          outputPhrase.setText(encryptedWord);
          
        }
        
        //if the decryption radio button is selected
        if(cryptOption == 1)
        {
          String decryptedWord = "";
          String phrase = inputPhrase.getText();
          int numcomboArray [] = new int[9];
          
          //for loop to initialize numComboArray to the 9 digit key
          for (int i=0; i<9; i++)
          {
            numcomboArray[i] = Integer.parseInt(comboArray[i].getText());
          }
          
          //making a decryption object
          Decryption encryptText = new Decryption(numcomboArray[0], numcomboArray[1],numcomboArray[2],numcomboArray[3],
                                                  numcomboArray[4], numcomboArray[5], numcomboArray[6], numcomboArray[7],
                                                  numcomboArray[8], phrase);
          
          //making a string equal to the return value of the decrpyt for loop method in decryptText
          decryptedWord = encryptText.decryptforLoop(1, Integer.parseInt(keyNumber1), Integer.parseInt(keyNumber2));
          
          outputPhrase.setText(decryptedWord);
        }
      }
      //error catching for specific exceptions
      catch (NumberFormatException error)
      {
        JOptionPane.showMessageDialog(null, "Invalid Key");
        JOptionPane.showMessageDialog(null, "Possible error:\nDecimal Input\nInteger over 40\nNegative integer input\nSpecial Character input\nInput Not available\nLetter instead of integer");
      }
      catch (ArrayIndexOutOfBoundsException error)
      {
        JOptionPane.showMessageDialog(null, "Invalid Key");
        JOptionPane.showMessageDialog(null, "Possible error:\nDecimal Input\nInteger over 40\nNegative integer input\nSpecial Character input\nInput Not available\nLetter instead of integer");
      }
    }
    
    //if read is clicked
    if (e.getSource()==btnRead)
    {
      //make an array of objects named options
      Object[] options = {"Normal Message", "Encrypted Message", "Cancel"};
      //making an option dialog box equal to an integer value
      int n = JOptionPane.showOptionDialog(btnRead, "Are you going to be loading an encrypted or decrypted message?", "Type Confirm", JOptionPane.YES_NO_CANCEL_OPTION,
                                           JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
      
      //if user clicked encrypted message
      if (n == 1)
      {
        //make option dialog box again asking if they want to load the key or text first
        Object[] options2 = {"Load Key" , "Load Text", "cancel"};
        int g = JOptionPane.showOptionDialog(btnRead, "Load Key or File First?", "Type Confirm", JOptionPane.YES_NO_CANCEL_OPTION,
                                             JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
        
        // Changes the radio button to decrypt
        radEncrypt.setSelected(false);
        radDecrypt.setSelected(true);
        
        //if user chooses load text
        if (g==1)
        {
          //call fileExlporer method to load text
          fileExplorer();
          //make another option dialog box asking if the user wants to enter the key now or later
          Object[] options3 = {"Load Key File", "Enter Key Later"};
          int t = JOptionPane.showOptionDialog (btnRead, "Do you still want to load the keyfile or will you put it in later?", "Type Confirm", 
                                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options3, options3 [0]);
          
          //if user wants to enter key now
          if (t == 0)
          {
            //call keyFileExploer method
            keyFileExplorer(); 
          }
          
        }
        //if user chooses to load key
        else if (g==0)
        {
          //call keyFileExplorer Method
          keyFileExplorer();
          
          //making option dialog box again to ask user if he/she wants to load text file now or later
          Object[] options4 = {"Load text File", "Enter text Later"};
          int z = JOptionPane.showOptionDialog (btnRead, "Do you still want to load the textfile or will you put the text in later?", "Type Confirm", 
                                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options4, options4 [0]);
          
          //if user wants to lood now
          if (z==0)
          {
            //call file explorer method
            fileExplorer();
          }
          
        }
      }
      //if user clicked normal message
      else if (n==0)
      {
        fileExplorer();
      }
    }
    
    //if save button is pressed
    if (e.getSource()==btnSave)
    {
      saveFileAsExplorer();
    }
    
    //if exit button is pressed
    if (e.getSource() == btnExit)
    {
      System.exit(0);
    }
  }
  
  //this method is meant to allow the user to search through her computer directories 
  //(using a filechooser) to open up a TEXT file to read
  private void fileExplorer()
  {
    
    try
    {
      int counter=0;
      String inputText="";
      //creating JFileChooser object named fc
      JFileChooser fc = new JFileChooser();
      //set this objects starting directory at home
      fc.setCurrentDirectory(new File(System.getProperty("user.home")));
      //only allow files with the ".txt" extension to show
      FileNameExtensionFilter filter = new FileNameExtensionFilter("text only", "txt");
      fc.setFileFilter(filter);
      
      //opens up FileChooser window on top of btnRead
      int returnVal = fc.showOpenDialog(btnRead); 
      
      if (returnVal == JFileChooser.APPROVE_OPTION) 
      {
        File selectedFile = fc.getSelectedFile();
        //counter to make sure selected file has a value
        //meant to avoid possible null pointer excpetions 
        counter++;
      }
      
      //if the file has a value
      if (counter==1)
      {
        inputText = ArrayLibrary.fileReader(fc.getSelectedFile());
        
        //if file is not found
        if (inputText.equals("error"))
        {
          fileExplorer();
        }
        //if file is found
        if (inputText!=("error"))
        {
          inputPhrase.setText(inputText);
        }
      }
      
      
    }
    catch(Exception h)
    {
      System.out.println("Unknown Error: File Explorer");
      h.printStackTrace();
    }
  }
  
  //this method is meant to allow a user to search for files with encrpyted keys, these keys
  //will then be decrypted and put into the appropriate places in the GUI
  private void keyFileExplorer()
  {
    try
    {
      //same as file file explorer
      int counter =0;
      String inputText;
      JFileChooser fc = new JFileChooser();
      fc.setCurrentDirectory(new File(System.getProperty("user.home")));
      FileNameExtensionFilter filter = new FileNameExtensionFilter("text only", "txt");
      fc.setFileFilter(filter);
      int returnVal = fc.showOpenDialog(btnRead); 
      if (returnVal == JFileChooser.APPROVE_OPTION) 
      {
        File selectedFile = fc.getSelectedFile();
        //counter to make sure selectedFile has a value
        counter++;
      }
      
      //if file has a value
      if (counter>=1)
      {
        inputText = ArrayLibrary.fileReader(fc.getSelectedFile());
        
        //if there is a problem with the file or it can't be found
        if (inputText.equals("error"))
        {
          //try again
          keyFileExplorer();
        }
        
        //if there is not a problem with the file
        if (inputText!=("error"))
        {
          String keyDigits;
          String strkeyDigits="";
          String strkeyDigits2="";
          
          //making a decryption object
          Decryption decrypting = new Decryption ();
          
          //making array of strings equal to the words between each comma 
          //in the inputText
          String [] key = inputText.split(",");
          
          //for loop that runs through all of the words in inputText
          for (int i =0; i<key.length; i++)
          {
            //putting the decrpyted digits together
            if (i==0)
            {
              keyDigits = decrypting.decryptKey(key[i]);
              strkeyDigits = keyDigits;
            }
            
            if (i == 1)
            {
              keyDigits = decrypting.decryptKey(key[i]);
              strkeyDigits = (strkeyDigits + "," + keyDigits);
            }
            
            if (i == 2)
            {
              keyDigits = decrypting.decryptKey(key[i]);
              strkeyDigits2 = keyDigits;
            }
            
            else
            {
              keyDigits = decrypting.decryptKey(key[i]);
              strkeyDigits2 = (strkeyDigits2 + "," + keyDigits);
            }
          }
          
          //for loop to initialize all 9 values of keys in the JTextFields in the GUI
          for (int i=0; i<9; i++)
          {
            comboArray[i].setText(strkeyDigits2.split(",")[i]);
          }
          
          //for loop to intialize the 2 keyList values 
          for (int i=0; i<3; i++)
          {
            keyList1.setSelectedIndex(Integer.parseInt(strkeyDigits.split(",")[0]));
            keyList2.setSelectedIndex(Integer.parseInt(strkeyDigits.split(",")[1]));
          } 
        }
      }     
    }
    //catching appropriate excpetions for error trapping
    catch(NumberFormatException h)
    {
      System.out.println("File does not contain the key, please load a file with the proper encrypted key");
      
    }
    catch (Exception h)
    {
      System.out.println("Unknown Error");
      h.printStackTrace(); 
    }
  }
  
  //this method allows users to look for a location to save their files
  //in a nice GUI manner
  private void saveFileAsExplorer()
  {
    try
    {
      //same as fileExplorer
      int counter=0;
      Encryption enc = new Encryption();
      JFileChooser fc = new JFileChooser();
      fc.setCurrentDirectory(new File(System.getProperty("user.home")));
      FileNameExtensionFilter filter = new FileNameExtensionFilter("text only", "txt");
      fc.setFileFilter(filter);
      int returnVal = fc.showSaveDialog(btnRead); 
      if (returnVal == JFileChooser.APPROVE_OPTION) 
      {
        File selectedFile = fc.getSelectedFile();
        counter++;
      }
      
      if (counter == 1)
      {
        String outputKey[] = new String[2];
        String outputKeys = "";
        //takes the keys and calls the encryptKey method in encryption to encrpyt them
        outputKey[0] = enc.encryptKey(keyNumber1);
        outputKey[1] = enc.encryptKey(keyNumber2);
        
        //for loop to combine  the two listKeys into one line with a comma separating the two 
        //values
        for (int i = 0; i < 2; i++)
        {
          if (i == 0)
          {
            outputKeys = outputKey[i];
          }
          else 
          {
            outputKeys = outputKeys + "," + outputKey[i];
          }
        }
        String comboKey [] = new String [9];
        
        //for loop to combine the 9 encrypted keys with commas added for separation.
        for (int i = 0; i < 9; i++)
        {
          comboKey[i] = enc.encryptKey(comboArray[i].getText());
          
          outputKeys = outputKeys + "," + comboKey[i];
        }      
        
        //calling arrayLibrary twice to make two files, one original one with the encrypted text, and 
        //a corresponding one with the key to decrypt the code
        ArrayLibrary.fileWriter(fc.getSelectedFile(), outputPhrase.getText());
        
        String keyFileName = fc.getSelectedFile().getName() + "key";
        // Gets path for text file
        String newKeyFileName = fc.getSelectedFile().getAbsolutePath();
        // Creates new file for key
        newKeyFileName = newKeyFileName + "key.txt";
        //Creates file
        File keyFile = new File (newKeyFileName);
        //Savesin file
        ArrayLibrary.fileWriter(keyFile, outputKeys);
      }
      
    }
    //cathes any problem with saving the file
    catch (IOException e)
    {
      JOptionPane.showMessageDialog(null, "File error");
    }
    
  }
  
  // When Object is selected (JTextArea)
  public void focusGained(FocusEvent e)
  {
    // Checks which one of the nine ComboArray JTextArea is selected
    for(int i=0; i<9; i++)
    {
      if (e.getSource() == comboArray[i])
      {
        // If JTextArea contains "#"
        if (comboArray[i].getText().equals("#"))
        {
          // Empties the JText Area
          comboArray[i].setText("");
        }
      }
    }
    
    // Checks if InputPhrase JTextArea is selected
    if (e.getSource() == inputPhrase)
    {
      // If JTextArea contains "Enter Phrase"
      if (inputPhrase.getText().equals("Enter Phrase"))
      {
        // Empties the JTextArea
        inputPhrase.setText("");
      }
    }
  }
  
  // When Object is no longer selected (JTextArea)
  public void focusLost (FocusEvent e)
  {
    // Checks which one of the nine ComboArray JTextArea is selected
    for(int i=0; i<9; i++)
    {
      if (e.getSource() == comboArray[i])
      {
        // If JTextArea is empty
        if (comboArray[i].getText().equals(""))
        {
          // Changes to "#"
          comboArray[i].setText("#");
        }
      }
      
      
    // Checks if InputPhrase JTextArea is selected
      if (e.getSource() == inputPhrase)
      {
        // If JTextArea is empty
        if (inputPhrase.getText().equals(""))
        {
          // Changes to "Enter Phrase"
          inputPhrase.setText("Enter Phrase");
        }
      }
    }
  }
  public static void main(String[] args) 
  {
    //making a CryptographyGUI object
    CryptographyGUI cg = new CryptographyGUI();
  }
}
