import java.util.Scanner;
class VoterValidation
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your name:-");
		String name = sc.nextLine();
		System.out.println("Enter your age:-");
		int age= sc.nextInt();
		System.out.println("Enter your phone number:-");
		int number = sc.nextInt();
		System.out.println("Enter your address:-");
		String address = sc.nextLine();
		try
		{
			if (age>=18)
			{
				System.out.println("You are eligible for voting...");
			}
			else
			{
				throw new InvalidAge();
			}
		}
		catch(InvalidAge ex)
		{
			System.out.println("Exception is occur");
		}
		//Ex10 e1 = new Ex10();
	}
}
class InvalidAge extends Exception
{
	public InvalidAge()
	{
		System.out.println("you are not eligible for voting ");
	}
}