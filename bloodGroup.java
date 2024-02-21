import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.event.*;
public class bloodGroup extends JFrame 
{
	public bloodGroup()
	{
		setLayout(null);
		setVisible(true);
		setTitle("Search By BloodGroup");
		setSize(1200,800);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[])
	{
		new bloodGroup();
	}
}