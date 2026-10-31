package _02_File_Encrypt_Decrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileEncryptor {
    public static void main(String[] args) {
    	JFileChooser chooser = new JFileChooser();
    	FileReader fr;
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
    	
    	try {
    		int result = chooser.showOpenDialog(null);
    		if (result == JFileChooser.APPROVE_OPTION) {
    		    File selectedFile = chooser.getSelectedFile();
    		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
    			fr = new FileReader(selectedFile);
    			
    		
			FileWriter fw = new FileWriter(selectedFile.getAbsolutePath() + "_encrypted", false);
			String key = JOptionPane.showInputDialog("Enter a key for how much u wanna shift, less than 26");
			int m = fr.read();
			int k = Integer.parseInt(key);
			while(m != -1){
				//System.out.print((char)c);
				//c = fr.read();
				if(Character.isLowerCase((char) m)) {
					m+=k;
					if(m>122) {
						m = (char) ((m-122)+96);
					}
					fw.write(m);
				}
				else if(Character.isUpperCase((char) m)) {
					m+=k;
					if(m>90) {
						m = (char) ((m-90)+64);
					}
					fw.write(m);
				}else {
					fw.write(m);
				}			
				
			m = fr.read();
			}
			
			/*
			for(int i = 0; i < selectedFile.length(); i++) {
				m = ((CharSequence) selectedFile).charAt(i);
				if(Character.isLowerCase(m)) {
					m+=k;
					if(m>122) {
						m = (char) ((m-122)+96);
					}
					fw.write(m);
				}
				else if(Character.isUpperCase(m)) {
					m+=k;
					if(m>90) {
						m = (char) ((m-90)+64);
					}
					fw.write(m);
				}else {
					fw.write(m);
				}
			}
    		
			/*
			NOTE: To append to a file that already exists, add true as a second parameter when calling the
			      FileWriter constructor.
			      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
			*/
			
			
				
			fw.close();
    		}
    	} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }
    
}