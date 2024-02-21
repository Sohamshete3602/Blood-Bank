import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.event.*;
public class allDonorDetails extends JFrame 
{
	public allDonorDetails()
	{
		setLayout(null);
		setVisible(true);
		setTitle("All Donor Details");
		setSize(1200,800);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[])
	{
		new allDonorDetails();
	}
}