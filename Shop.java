import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Shop
{
	static Scanner sc = new Scanner(System.in);
	public int ans=1, total=0, cID;
	public Customer c ;
	public DatabaseOP Dao = new DatabaseOP();
		
	public List<Product> createProduct()
	{
		List<Product> p = new LinkedList<Product>();
		
		do
		{ 
			System.out.println("-------------------------------------------");
			System.out.println("Enter Product ID And Qty :-\t");
			int pid = sc.nextInt();
			if(pid!=0)
			{
				int pqty = sc.nextInt();
				Product proc= Dao.FindProduct(pid, pqty);
				p.add(proc);
				ans = 1;
			}
			else
			{
				ans = 0;
			}
		}while(ans==1);		
		return p;
	}
	
	public void Display(Customer c)
	{
		c.setP(createProduct());
		System.out.println("\n\n-------------------------------------------------------");
		System.out.println("Customer ID :-\t\t"+c.getCustId());
		System.out.println("Customer Name :-\t"+c.getCustName());
		System.out.println("-------------------------------------------------------");
		System.out.println("Address :-\t"+c.getAddr().getAddress()+", "+c.getAddr().getCity()+", "+c.getAddr().getState()+" - "+c.getAddr().getPincode());
		System.out.println("Mobile No.:-\t"+c.getAddr().getMob1());
		System.out.println("2'nd Mob No.:-\t"+c.getAddr().getMob2());
		System.out.println("Email :-\t"+c.getAddr().getEmail());
		System.out.println("-------------------------------------------------------");
		System.out.println("Product ID  Product Name\tQty\tPrice\tAmount");
		System.out.println("-------------------------------------------------------");
		for(int i=0;i<c.getP().size();i++)
		{
			System.out.println(c.getP().get(i).getProdId()+"\t\t"+c.getP().get(i).getProcName()+"\t\t"+c.getP().get(i).getProcQty()+"\t"+c.getP().get(i).getProcPrice()+"\t"+c.getP().get(i).getProcAmt());
		}
		System.out.println("-------------------------------------------------------");
		total = createBill(c);
		System.out.println("\t\t\t\t\tAWOGST:- "+total);
		System.out.println("-------------------------------------------------------");
		float gst = (total * 5)/100;
		float finalamt = total+gst+gst;
		c.setBillAmt((int)finalamt);
		Dao.updateCustomer(c.getCustId(), finalamt);
		System.out.println("\t\t\t\t\tCGST:-\t"+gst);
		System.out.println("\t\t\t\t\tSGST:-\t"+gst);
		System.out.println("-------------------------------------------------------");
		System.out.println("\t\t\t\t\tTOTAL:-\t"+finalamt);
		System.out.println("-------------------------------------------------------");
	}
	
	public Contact createContact()
	{
		System.out.println("Enter Customer's Primary And Secondary Mobile Number :-\t");
		long mob1 = sc.nextLong();
		long mob2 = sc.nextLong();
		System.out.println("Enter Customer's Email ID :-\t");
		String email = sc.next();
		Contact cont = new Contact(mob1,mob2,email);
		return cont;
	}
	
	public Address createAddress()
	{
		Contact cont = createContact();
		System.out.println("Enter Customer's Address, City, State And Pincode :-\t");
		String add = sc.next();
		String city = sc.next();
		String state = sc.next();
		int pin = sc.nextInt();
		Address addr = new Address(add,city,state,pin,cont.getMob1(),cont.getMob2(),cont.getEmail());
		return addr;
	}
	
	public void createCustomer()
	{ 
		System.out.println("Enter Customer Id and Name :-\t");
		int cid = sc.nextInt();
		String cname = sc.next();
		Address a = createAddress();
		Dao.createAddress(cid, a);
		Customer c = new Customer(cid,cname,a);
		Dao.createCustomer(c);
	}
	
	public int createBill(Customer c)
	{
		for(int i=0;i<c.getP().size();i++)
		{
			total = total + c.getP().get(i).getProcAmt();
		}
		return total;
	}
	
	public void createShop()
	{
		do
		{
			System.out.println("----------------------------------------");
			System.out.println("1.Create Customer\n2.Create Bill\n3.Delete Customer\n4.Exit\nEnter Your Choice :-\t");
			int sch = sc.nextInt();
		switch(sch)
		{
		case 1:
			System.out.println("----------------------------------------");
			createCustomer();
			break;
		case 2:
			System.out.println("----------------------------------------");
			System.out.println("Enter Customer ID :-\t");
			cID = sc.nextInt();
			c = Dao.findCustomer(cID);
			if(c == null)
				System.out.println("Customer Not Found..!");
			Display(c);
			break;
		case 3:
			System.out.println("----------------------------------------");
			System.out.println("Enter Customer ID :-\t");
			cID = sc.nextInt();
			c = Dao.findCustomer(cID);
			Dao.deleteCustomer(c);
			break;
		case 4:
			System.out.println("Thank You...!");
			ans=4;
			break;
		default :
				System.out.println("Wrong Choice...!");
		}
		}while(ans!=4);
	}
}
