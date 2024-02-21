import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.event.*;
public class increaseStock extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JButton b1,b2;
	JComboBox c1;
	JTextField t1;
	String s1[]={"a+","a-","b+","b-","o+","o-","ab+","ab-"};
	public increaseStock()
	{
		setLayout(null);
		setVisible(true);
		setTitle("Increase Stock");
		
		l1=new JLabel("Blood Group");
		l1.setBounds(200,100,150,40);
		c1=new JComboBox(s1);
		c1.setBounds(400,100,100,40);
		
		l2=new JLabel("Blood Quantity");
		l2.setBounds(200,150,150,40);
		t1=new JTextField();
		t1.setBounds(400,150,100,40);
		
		ImageIcon im1=new ImageIcon("bg3.jpg");
		l3=new JLabel(im1);
		l3.setBounds(0,0,1200,800);
		
		b1=new JButton("Update");
		b1.setBounds(250,200,100,40);
		b2=new JButton("Cancel");;
		b2.setBounds(350,200,100,40);
		
		setSize(1200,800);
		
		add(l1);add(l2);add(b1);add(b2);add(c1);add(t1);add(l3);
		setLocation(300,100);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		try
		{
			String s=ae.getActionCommand();
			if (s.equals("Update"))
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				//JOptionPane.showMessageDialog(this,"Driver Registered");

				Connection co=DriverManager.getConnection("jdbc:odbc:bbms");
				
				String bg=(String)c1.getSelectedItem();
				int qu=Integer.parseInt(t1.getText());
				
				PreparedStatement ps=co.prepareStatement("Update blood set quantity=? where bloodg=?");
				ps.setInt(1,qu);
				ps.setString(2,bg);
				ps.executeUpdate();
				
				co.close();
				JOptionPane.showMessageDialog(this,"Data Updated Successfully");
				setVisible(false);
				new increaseStock().setVisible(true);
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
		new increaseStock();
	}
}