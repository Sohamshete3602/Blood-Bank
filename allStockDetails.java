import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.event.*;
public class allStockDetails extends JFrame implements ActionListener
{
	JTable tb1;
	JTextField search;
	int count=0;
	public allStockDetails()
	{
		setLayout(null);
		setVisible(true);
		
		/*search = new JTextField();
		search.setBounds(189, 89, 357, 33);
		add(search);
		search.setColumns(2);*/
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection co=DriverManager.getConnection("jdbc:odbc:bbms");
			String sql = "select * from blood";						
            PreparedStatement ps = co.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
			
			String colHeads[]={"Blood group","Quantity"};
			String data[][]={
						{"",""},
						{"",""},
						{"",""},
						{"",""},
						{"",""},
						{"",""},
						{"",""},
						{"",""}};
						
			tb1 = new JTable(data,colHeads);
			/*tb1.addMouseListener(new MouseAdapter() 
			{
            	public void mouseClicked(MouseEvent me)
				{
                	int row = tb1.getSelectedRow();
					search.setText(tb1.getModel().getValueAt(row, 1).toString());
            	}
			});*/
			
			int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
			int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;	
	
			JScrollPane scrollPane = new JScrollPane(tb1, v, h);
			scrollPane.setBounds(79, 133, 771, 282);
			
			while(rs.next())
			{
				tb1.setValueAt(rs.getString(1),count,0);
				tb1.setValueAt(rs.getString(2),count,1);
				count++;
			}
			ps.close();
            co.close();
			add(scrollPane);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this,e);	
		}
		
		setTitle("All Stock Details");
		setSize(1200,800);
		//add(tb1);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{}
	
	public static void main(String args[])
	{
		new allStockDetails();
	}
}