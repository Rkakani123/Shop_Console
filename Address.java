public class Address extends Contact 
{
	public String address, city, state;
	public int pincode;
	
	public Address(String address, String city, String state, int pincode,long mob1, long mob2, String email)
	{
		super(mob1, mob2, email);
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		
	}
	
	public String getAddress() 
	{
		return address;
	}

	public String getCity() 
	{
		return city;
	}

	public String getState() 
	{
		return state;
	}

	public int getPincode() 
	{
		return pincode;
	}
}
