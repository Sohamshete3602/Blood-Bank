import java.io.*;
import java.util.Scanner;
class ProbStat11
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("1.write");
		System.out.println("2.Read");
		System.out.println("Enter your choice:-");
		int choice = sc.nextInt();
		try
		{
		File f= new File ("new.txt");
			boolean Flag=f.createNewFile();
			if(Flag)
			{
				System.out.println("File created"+f.getName());
				
			}
			else
			{
				System.out.println("File is already exist");
				
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		switch(choice)
		{
			case 1:
			try 
			{
			 FileOutputStream fileout = new FileOutputStream("new.txt");
               String s= "This content are written by the FileOutputStream class";
              byte b[]=s.getBytes();
             fileout.write(b);
             fileout.close();
              System.out.println("File is successfully updated");			 
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			break;
			case 2:
			try
			{
			FileInputStream filein= new FileInputStream("new.txt");
			int i=0;
			while((i=filein.read())!=-1)
			{
				System.out.print((char)i);
			}
			filein.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			
			break;
			default :
			System.out.println("Select the valid choice");
		}
		
	}
}