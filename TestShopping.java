import java.util.*;

public class TestShopping 
{
	public static void main(String[] args)
	{
		int ch;
		Shop shop = new Shop();
		Admin a = new Admin();
		Scanner sc = new Scanner(System.in);
		do
		{
		System.out.println("---------------- SHOP ----------------");
		System.out.println("1.Shopping\n2.Administration\n3.Exit\nEnter Your Choice :-");
		ch= sc.nextInt();
		switch(ch)
		{
		case 1:
			shop.createShop();
			break;
		case 2:
			a.admin();
			break;
		case 3:
			System.out.println("Thank You..!");
			break;
		default :
				System.out.println("Wrong Choice...!");			
		}
		}while(ch!=3);
	}
}
