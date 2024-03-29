import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.event.*;
public class deleteDonor extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JButton b1,b2;
	JTextField t1;
	public deleteDonor()
	{
		setLayout(null);
		
		setTitle("Delete Donor");
		
		l1=new JLabel("Donor ID");
		l1.setBounds(100,100,150,50);
		ImageIcon im1=new ImageIcon("bg3.jpg");
		l2=new JLabel(im1);
		l2.setBounds(0,0,1200,800);
		
		t1=new JTextField();
		t1.setBounds(200,100,150,50);
		
		b1=new JButton("Delete");
		b1.setBounds(400,100,100,50);
		b2=new JButton("Cancel");;
		b2.setBounds(500,100,100,50);
		
		setSize(1200,800);
		
		add(l1);add(b1);add(b2);add(t1);add(l2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setVisible(true);
		setLocation(300,100);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		try
		{
			String s=ae.getActionCommand();
			if (s.equals("Delete"))
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				//JOptionPane.showMessageDialog(this,"Driver Registered");

				Connection co=DriverManager.getConnection("jdbc:odbc:bbms");
				
				int id=Integer.parseInt(t1.getText());
				
				PreparedStatement ps=co.prepareStatement("delete from donor where ID=?");
				ps.setInt(1,id);
				
				ps.executeUpdate();
				
				co.close();
				JOptionPane.showMessageDialog(this,"Donor Deleted Successfully");
				setVisible(false);
				new deleteDonor().setVisible(true);
			}
			if(s.equals("Cancel"))
			{
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to close window", "Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					setVisible(false);
					new home().setVisible(true);
				}
				new home().setVisible(true);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,e);
		}
	}
	public static void main(String args[])
	{
		new deleteDonor();
	}
}