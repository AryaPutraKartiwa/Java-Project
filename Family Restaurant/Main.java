import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<Regular> reg = new ArrayList<>();
	ArrayList<Special> spec = new ArrayList<>();
	Random random = new Random();
	
	public void RegMenu()
	{
		
		String Code;
		String Name;
		Double Price;
		
		int num;
		Code = "R";
		
		for (int i = 0; i < 3; i++) 
		{
			num = random.nextInt(10);
			Code = Code + num;
		}
		
		
		do {
			System.out.println("Input Menu Name [5-20]: ");
			Name = scan.nextLine();
		} while (Name.length()<5 || Name.length()>20);
		
		do {
			System.out.println("Input Menu Price [10000 - 100000]: ");
			Price = scan.nextDouble();
		} while (Price < 10000 || Price >100000);
		
		reg.add(new Regular(Code,Name,Price));
		System.out.println("Add Success!");
		System.out.println();
		
	}
	
	public void SpecMenu()
	{

		String Code;
		String Name;
		Double Price;
		Double Discount;
		Double TotalPrice;
		
		int num;
		Code = "S";
		for (int i = 0; i < 3; i++) 
		{
			num = random.nextInt(10);
			Code = Code + num;
		}
		
		
		do {
			System.out.println("Input Menu Name [5-20]: ");
			Name = scan.nextLine();
		} while (Name.length()<5 || Name.length()>20);
		
		do {
			System.out.println("Input Menu Price [10000 - 100000]: ");
			Price = scan.nextDouble();
		} while (Price < 10000 || Price >100000);
		do {
			System.out.println("Input Menu Discount [ 10% | 25% | 50% ]: ");
			Discount = scan.nextDouble();
		} while (Discount!=10 && Discount != 25 && Discount !=50);
		
		TotalPrice = Price * ((100-Discount)/100);
		
		spec.add(new Special(Code,Name,Price,Discount,TotalPrice));
		System.out.println("Add Success!");
		System.out.println();
	}
	void ShowRegular()
	{
		System.out.println("Reguler Menu");
		System.out.println("==========================================");
		System.out.printf("%-6s| %-5s| %-12s | %-10s |\n","No.","Code","Name","Price");
		System.out.println("==========================================");
		for (int i = 0; i < reg.size(); i++) 
		{
			System.out.printf("%-7d %-6s %-14s %-10.0f |\n",i+1,reg.get(i).getCode(),reg.get(i).getName(),reg.get(i).getPrice());
		}
		System.out.println("==========================================");
		System.out.println();
	}
	void ShowSpecial()
	{
		System.out.println("Special Menu");
		System.out.println("=====================================================================");
		System.out.printf("%-6s| %-5s| %-12s | %-10s | %-10s | %-10s |\n","No.","Code","Name","Price","Discount","Final Price");
		System.out.println("=====================================================================");
		for (int i = 0; i < spec.size(); i++) 
		{
			System.out.printf("%-7d %-6s %-14s %-14.0f %.0f%%         %-11.0f|\n",i+1,spec.get(i).getCode(),spec.get(i).getName(),spec.get(i).getPrice(),spec.get(i).getDiscount(),spec.get(i).getTotalPrice());
		}
		System.out.println("=====================================================================");
		System.out.println();
	}
	
	public void ShowMenu()
	{
		
		if(reg.isEmpty()&&spec.isEmpty())
		{
			System.out.println("No Data");
		}
		else
		{
			ShowRegular();
			ShowSpecial();
			System.out.println("Press Enter To Continue....");
			scan.nextLine();
			
		}
	}
	public void DeleteReg()
	{
		if(reg.isEmpty())
		{
			System.out.println("No Data");
		}
		else
		{	
			ShowRegular();
			String select;
			System.out.println("Input Menu Code [R...]: ");
			select = scan.nextLine();
			int index = -1;
			for (int i = 0; i < reg.size(); i++) 
			{
				if(select.equals(reg.get(i).getCode()))
				index = i;
			}
			if(index==-1)
			{
				System.out.println("Code Is Wrong");
			}
			else
			{
				reg.remove(index);
				System.out.println("Delete Success");
			}
			
		}
	}
	
	public void DeleteSpec()
	{
		if (spec.isEmpty()) 
		{
			System.out.println("No Data");
		}
		else
		{
			ShowSpecial();
			String select;
			System.out.println("Input Menu Code [S...}");
			select = scan.nextLine();
			int index = -1;
			for (int i = 0; i < spec.size(); i++) 
			{
				if (select.equals(spec.get(i).getCode())) 
				{
					index = i;
				}
			}
			if (index ==-1) 
			{
				System.out.println("Wrong Code");
			}
			else
			{
				spec.remove(index);
				System.out.println("Delete Success!");
			}
		}
	}
	
	void menu()
	{
		int select = 0;
		do {
			System.out.println();
			System.out.println("Family Restaurant");
			System.out.println("============================");
			System.out.println("1. Add Regular Menu");
			System.out.println("2. Add Special Menu");
			System.out.println("3. Show All Menu");
			System.out.println("4. Delete Regular Menu");
			System.out.println("5. Delete Special Menu");
			System.out.println("6. Exit");
			System.out.println("Choice [1-6]: ");
			select = scan.nextInt();
			scan.nextLine();
			
			switch (select) {
			case 1:
				RegMenu();
				break;

			case 2:
				SpecMenu();
				break;
				
			case 3:
				ShowMenu();
				break;
			case 4:
				DeleteReg();
				break;
				
			case 5:
				DeleteSpec();
				break;
				
			case 6:
				System.out.println("Have a nice day... :)");
				break;
			}
			
		} while (select!=6);
	}
	
	public Main()
	{
		menu();
	}
	public static void main(String[] args) 
	{
		new Main();

	}

}
