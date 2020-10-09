public class Product
{
	private int prodId;
	private String procName;
	private int procQty;
	private int procPrice;
	private int procAmt;
	
	public Product(int prodId, String procName,int procQty, int procPrice) 
	{
		this.prodId = prodId;
		this.procName = procName;
		this.procQty =procQty;
		this.procPrice = procPrice;
		procAmt = procQty*procPrice;
	}

	public int getProdId() 
	{
		return prodId;
	}

	public String getProcName() 
	{
		return procName;
	}

	public int getProcPrice() 
	{
		return procPrice;
	}

	public int getProcQty() 
	{
		return procQty;
	}

	public int getProcAmt()
	{
		return procAmt;
	}

	
	
}
