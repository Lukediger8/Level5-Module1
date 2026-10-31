package _03_To_Do_List;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList {
    public static void main(String[] args) {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */

JPanel panel = new JPanel();
JFrame frame = new JFrame();
JButton addTask = new JButton();
JButton viewTask = new JButton();
JButton removeTask = new JButton();
JButton saveList = new JButton();
JButton loadList = new JButton();
frame.add(panel);
panel.add(addTask);
panel.add(viewTask);
panel.add(removeTask);
panel.add(saveList);
panel.add(loadList);
addTask.setText("Add Task");
viewTask.setText("View Tasks");
removeTask.setText("Remove Tasks");
saveList.setText("Save List");
loadList.setText("Load List");
ArrayList<String> arr = new ArrayList<>();
addTask.addActionListener(e ->{String task = JOptionPane.showInputDialog("Enter a task that you want me to put in your to-do list.");
arr.add(task);
});
viewTask.addActionListener(e -> {
	
	
	
});
removeTask.addActionListener(e->{
	String task = JOptionPane.showInputDialog("What task would you like to remove from your to-do list?");
	
	
});





    }
}
