package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
    public static void main(String[] args) {
	int c = 0;
	String key = JOptionPane.showInputDialog("What is the key you want to use to decode the following text?");
	int keynum = Integer.parseInt(key);
	StringBuilder s = new StringBuilder();
	try {
		FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/encrypt.txt");
		while(c != -1){
			//System.out.print((char)c);
			c = fr.read();
			if(c==-1){
				break;
			}
			s.append((char) c);
		
		}
		fr.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/text.txt");
		//fw.write();
		String message = s.toString();
		for(int i = 0; i < message.length(); i++) {
			char m = message.charAt(i);
			if(Character.isLowerCase(m)) {
				m-=keynum;
				if(m<97) {
					m = (char) (122-(97-m)+1);
				}
				fw.write(m);
			}
			else if(Character.isUpperCase(m)) {
				m-=keynum;
				if(m<90) {
					m = (char) ((64-(90-m)));
				}
				fw.write(m);
			}else {
				fw.write(m);
			}
		}
		fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}

	}

}