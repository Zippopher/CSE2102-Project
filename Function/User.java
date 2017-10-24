package Function;

public class User 
{
	private String username;
	private long password;
	
	// base constructor
	public User()
	{}
	
	// general constructor
	public User(String name, String pass)
	{
		username = name;
		password = hashCode(pass);
	}
	
	// adds a new review
	public void createReview()
	{
		
	}
	
	// searches through the list of restaurants with certain criteria
	public Restaurant[] search(String term, int type)
	{
		if(type == 0) //Search by name
		{
			return Main.searchName(term);
		}
		else if(type == 1) //Search by rating
		{
			return Main.searchRate(Double.parseDouble(term));
		}
		else if(type == 2) //Search by price
		{
			return Main.searchPrice(Double.parseDouble(term));
		}
		else
		{
			return new Restaurant[0];
		}
	}
	
	// turns a string into a polynomial hash for storing passwords and checking them.
	public long hashCode(String str)
	{
		int hash = 0;
		for(int i = 0; i < str.length(); i++)
		{
			hash = (41 * hash) + str.charAt(i);
		}
		return hash;
	}
	
	// accessor methods
	public String getUsername()
	{
		return username;
	}
	public long getPassword()
	{
		return password;
	}
	// protected mutators
	protected void setUsername(String user)
	{
		username = user;
	}
	protected void setPassword(long pass)
	{
		password = pass;
	}
}
