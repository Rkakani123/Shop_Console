import java.util.Scanner;

public class Admin 
{
	public DatabaseOP db = new DatabaseOP();
	public Scanner sc = new Scanner(System.in);
	int ach;
	public void getProducts()
	{
		boolean ans;
		
		do
		{
		System.out.println("-------------------------------------------");
		System.out.println("Enter Product ID, Name And Price :-\t");
		int pid = sc.nextInt();
		if(pid!=0)
		{
			String pname = sc.next();
			int pprice = sc.nextInt();
			Product proc= new Product(pid,pname,0,pprice);
			db.createProduct(proc);
			ans = true;
		}
		else
		{ 	ans = false;	}
		
		}while(ans);
	}
	
	public void delProduct()
	{
		System.out.println("-------------------------------------------");
		System.out.println("Enter Product ID :-\t");
		int pid = sc.nextInt();
		db.deleteProduct(pid);
	}
	
	public void update()
	{
		System.out.println("-------------------------------------------");
		System.out.println("Enter Product ID :-\t");
		int pid = sc.nextInt();
		System.out.println("Enter New Price :-\t");
		float price = sc.nextFloat();
		db.updateProduct(pid,price);
	}
	
	public void admin()
	{
		int ans=0;
		do
		{
			System.out.println("----------------------------------------");
			System.out.println("1.Add Products\n2.Update Product\n3.Delete Product\n4.Exit\nEnter Your Choice :-\t");
			int ach = sc.nextInt();
			switch(ach)
			{
			case 1:
				//System.out.println("----------------------------------------");
				getProducts();
				break;
			case 2:
				//System.out.println("----------------------------------------");
				update();
				break;
			case 3:
				//System.out.println("----------------------------------------");
				delProduct();
				break;
			case 4:
				System.out.println("Thank You...!");
				ans = 1;
				break;
			default:
				System.out.println("Wrong Choice...!");	
			}
		}while(ans!=1);
	}
}
