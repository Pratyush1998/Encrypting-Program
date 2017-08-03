/*Name: Pratyush Bhandari
 *Date: 6/14/2016
 *Description: This class is meant to hold a collection of useful methods that can be used
 *             by any of the classes in the cryptography program
 *
 *Method List:
 *int int searchletter(char [] array, char searchKey)
 *void fileWriter (File file, String output)
 *void fileWriter (String file, String output)
 *void fileWriter (String file, String[] output)
 *String fileReader(File file)
 *String[] keyFileReader(File file)
 */

//importing needed packages
import java.io.*;
import java.util.*;
import javax.swing.*;

public class ArrayLibrary {
  
	public static int searchletter(char [] array, char searchKey){
    int index = -1;
    
    for(int i=0; i < 40; i++)
    {
      // if the strings match, save the location and exit the loop
      int j = (int)array[i];
      int k = (int)searchKey;
      if (array[i] == searchKey){
        index = i;
        break;
      }               
    }
    return index;
  }
  
  public static void fileWriter (File file, String output)throws IOException
  { 
    try
    {
   		PrintWriter fw = new PrintWriter(new FileWriter(file+".txt"));//creates and opens a new file
	    
	    // prints a line with the entire output string passed in by the user
	    fw.println(output);
	   
	    fw.close();//closes the file
    }
    catch (Exception e)
    {
    	JOptionPane.showMessageDialog(null, "Unknown Error");
    }
  }
  
   public static void fileWriter (String file, String output)throws IOException
   { 
     try
     {
     	 PrintWriter fw = new PrintWriter(new FileWriter(file+".txt"));//creates and opens a new file
	     fw.println(output);
	     fw.close();//closes the file
     }
     catch (Exception e)
     {
     	JOptionPane.showMessageDialog(null, "Unknown Error");
     }
   }
  
  public static void fileWriter (String file, String[] output) throws IOException
  {
    try
    {
    	PrintWriter fw = new PrintWriter(new FileWriter(file+".txt"));//creates and opens a new file
	    for (int i=0; i<2; i++)
	    {
	     fw.println(output[i]); 
	    }
	    fw.close();//closes the file	
    }
    catch (Exception e)
    {
    	JOptionPane.showMessageDialog(null, "Unknown Error");
    }
    
  }
  
  
  public static String fileReader(File file)throws IOException
  {
   
   String line="";
   try 
   {
        // Create a new Scanner object which will read the data
        // from the file passed in. To check if there are more 
        // line to read from it we check by calling the 
        // scanner.hasNextLine() method. We then read line one 
        // by one till all line is read.
        
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNextLine()) 
        {
            
            line = line + scanner.nextLine();
   
        }
        
        return line;
     }
     catch(FileNotFoundException e)
     {
     	JOptionPane.showMessageDialog (null, "File not found, please try again.");
     	return "error";
     }
     catch (Exception e) 
     {
            JOptionPane.showMessageDialog(null, "Unknown Error, try again");
            e.printStackTrace();
            return "error";
     }
        
  }
  
  
  
  public static String[] keyFileReader(File file)throws IOException
  {
   
   //creating an array of 2 strings called line
   String[] line = new String[2];
   
   try 
   {
        // Create a new Scanner object which will read the data
        // from the file passed in. To check if there are more 
        // line to read from it we check by calling the 
        // scanner.hasNextLine() method. We then read line one 
        // by one till all line is read.
        
        Scanner scanner = new Scanner(file);
        
        //initialzing line 
        for (int i=0; i<2; i++)
        {
            line[0] = scanner.nextLine();
     	}
        
        return line;
     }
     catch (Exception e) 
     {
            JOptionPane.showMessageDialog(null, "this error is coming from keyFileReader in ArrayLibrary");
            e.printStackTrace();
     }
        return line;
  }
}