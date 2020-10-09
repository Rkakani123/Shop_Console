import java.util.*;

public class Customer
{
	private int custId;
	private String custName;
	private List<Product> p;
	private Address addr;
	private int BillAmt;
	
	public Customer(int custId, String custName, Address addr) 
	{
		this.custId = custId;
		this.custName = custName;
		this.addr = addr;
		BillAmt = 0;
	}

	public Address getAddr() 
	{
		return addr;
	}

	public int getCustId() 
	{
		return custId;
	}

	public String getCustName() 
	{
		return custName;
	}

	public List<Product> getP()
	{
		return p;
	}

	public void setP(List<Product> p) 
	{
		this.p = p;
	}

	public int getBillAmt()
	{
		return BillAmt;
	}

	public void setBillAmt(int billAmt)
	{
		BillAmt = billAmt;
	}
		
}
