public class Contact
{
	private long mob1;
	private long mob2;
	private String email;
	
	public Contact(long mob1, long mob2, String email) 
	{
		this.mob1 = mob1;
		this.mob2 = mob2;
		this.email = email;
	}

	public long getMob1()
	{
		return mob1;
	}

	public long getMob2()
	{
		return mob2;
	}

	public String getEmail() 
	{
		return email;
	}
	
	
}
