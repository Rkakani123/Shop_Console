import java.sql.*;

public class DatabaseOP 
{
	Connection Conn;
	public DatabaseOP()
	{
		try
		{
			Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","Rkakani");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void createCustomer(Customer c)
	{
		try
		{
			CallableStatement cs = Conn.prepareCall("call add_Cust(?,?,?)");
			cs.setInt(1,c.getCustId());
			cs.setString(2,c.getCustName());
			cs.setFloat(3,c.getBillAmt());
			cs.execute();
		}
		catch(Exception e)
		{
			System.out.println("Oops..! Something Went Wrong...!");
		}
	}
	
	public void deleteCustomer(Customer c)
	{
		try
		{
			CallableStatement cs = Conn.prepareCall("call del_Cust(?)");
			PreparedStatement ps = Conn.prepareStatement("delete from address where CID = ?");
			cs.setInt(1,c.getCustId());
			ps.setInt(1,c.getCustId());
			cs.execute();
			ps.execute();
		}
		catch(Exception e)
		{
			System.out.println("Unable To Delete Customer...! ");
		}
	}
	
	public void updateCustomer(int pid, float nBill)
	{
		try
		{
			PreparedStatement ps = Conn.prepareStatement("update customer set BillAmt = ? where cId = ?");
			ps.setInt(2,pid);
			ps.setFloat(1,nBill);
			ps.execute();
		}
		catch(Exception e)
		{
			System.out.println("Unable To Update Customer...!");
		}
	}
	
	public Customer findCustomer(int cID)
	{
		Customer c = null;
		try
		{
			CallableStatement cs = Conn.prepareCall("call find_Cust(?)");
			cs.setInt(1,cID);
			ResultSet rs = cs.executeQuery();
			rs.next();
			Address Addr  = getAddress(cID);
			c = new Customer(rs.getInt(1), rs.getString(2),Addr);
			if(c == null)
				throw new Exception();
		}
		catch(Exception e)
		{
			System.out.println("Unable To Find Customer...!");
		}
		return c;
	}
	
	public void createAddress(int cID, Address a) 
	{
		try
		{
			CallableStatement cs = Conn.prepareCall("call add_Addr(?,?,?,?,?,?,?,?)");
			cs.setInt(1,cID);
			cs.setString(2,a.address);
			cs.setString(3,a.city);
			cs.setString(4,a.state);
			cs.setInt(5,a.pincode);
			cs.setLong(6,a.getMob1());
			cs.setLong(7,a.getMob2());
			cs.setString(8,a.getEmail());
			cs.execute();
		}
		catch(Exception e)
		{
			System.out.println("Oops..! Something Went Wrong...!");
		}
	}
 
	public Address getAddress(int cId)
	{
		Address addr=null;
		try
		{
			CallableStatement cs = Conn.prepareCall("call find_Addr(?)");
			cs.setInt(1,cId);
			ResultSet rs = cs.executeQuery();
			rs.next();
			addr = new Address(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getLong(6), rs.getLong(7), rs.getString(8));
			if(addr == null)
				throw new Exception();
		}
		catch(Exception e)
		{
			System.out.println("Oops..! Something Went Wrong...!");
		}
		return addr;
	}
	
	public void createProduct(Product p)
	{
		try
		{
			CallableStatement cs = Conn.prepareCall("call add_Proc(?,?,?)");
			cs.setInt(1,p.getProdId());
			cs.setString(2,p.getProcName());
			cs.setFloat(3,p.getProcPrice());
			cs.execute();
		}
		catch(Exception e)
		{
			System.out.println("Oops..! Something Went Wrong...!");
		}
	}
	
	public Product FindProduct(int pID, int pQty)
	{
		Product p = null;
		try
		{
			CallableStatement cs = Conn.prepareCall("call find_Proc(?)");
			cs.setInt(1,pID);
			ResultSet rs = cs.executeQuery();
			if(rs.next())
				p = new Product(rs.getInt(1), rs.getString(2), pQty, rs.getInt(3));
			if(p == null)
				throw new Exception();
		}
		catch(Exception e)
		{
			System.out.println("Unable To Find Product..!");
		}
		return p;
	}

	public void deleteProduct(int pid)
	{
		try
		{
			CallableStatement cs = Conn.prepareCall("call del_Proc(?)");
			cs.setInt(1,pid);
			cs.execute();
		}
		catch(Exception e)
		{
			System.out.println("Oops..! Something Went Wrong...!");
		}
	}
	
	public void updateProduct(int pid, float nPrice)
	{
		try
		{
			CallableStatement cs = Conn.prepareCall("call update_Proc(?,?)");
			cs.setInt(1,pid);
			cs.setFloat(2,nPrice);
			cs.execute();
		}
		catch(Exception e)
		{
			System.out.println("Unable To Update Product..!");
		}
	}
}
