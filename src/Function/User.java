package Function;

import java.util.ArrayList;
import java.util.LinkedList;

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
	public void createReview(Restaurant rest, int oRate, int fRate, int sRate, int pRate, String rev)
	{
		rest.addReview(new Review(rest, oRate, fRate, sRate, pRate, this, rev));
	}
	
	// A Login Method
	public User verifyUser(String name, String pass, LinkedList<User> users)
	{
		long hash = hashCode(pass);
		for(User u : users)
		{
			if(u.getUsername().equals(name) && u.getPassword() == hash)
			{
				return u;
			}
		}
		return null;
	}
	
	// searches through the list of restaurants with certain criteria
	public Restaurant[] search(String term, int type, LinkedList<Restaurant> restaurants)
	{
		if(type == 0) //Search by name
		{
			return searchName(term, restaurants);
		}
		else if(type == 1) //Search by rating
		{
			return searchRate(Double.parseDouble(term), restaurants);
		}
		else if(type == 2) //Search by price
		{
			return searchPrice(Double.parseDouble(term), restaurants);
		}
		else
		{
			return new Restaurant[0];
		}
	}
	
	// Search Methods to interact with the List in specific ways
	private Restaurant[] searchName(String name, LinkedList<Restaurant> restaurants)
	{
		ArrayList<Restaurant> results = new ArrayList<Restaurant>();
		for(Restaurant r : restaurants)
		{
			if(r.getName().toLowerCase().contains(name.toLowerCase()))
				results.add(r);
		}
		return results.toArray(new Restaurant[results.size()]);
	}
	private Restaurant[] searchRate(double rate, LinkedList<Restaurant> restaurants)
	{
		double min = rate - 0.5;
		double max = rate + 0.5;
		ArrayList<Restaurant> results = new ArrayList<Restaurant>();
		for(Restaurant r : restaurants)
		{
			if(r.getAvgRate() >= min && r.getAvgRate() <= max)
				results.add(r);
		}
		return results.toArray(new Restaurant[results.size()]);
	}
	private Restaurant[] searchPrice(double price, LinkedList<Restaurant> restaurants)
	{
		double min = price - 0.5;
		double max = price + 0.5;
		ArrayList<Restaurant> results = new ArrayList<Restaurant>();
		for(Restaurant r : restaurants)
		{
			if(r.getAvgPrice() >= min && r.getAvgPrice() <= max)
				results.add(r);
		}
		return results.toArray(new Restaurant[results.size()]);
	}
	
	public void addUser(User u, LinkedList<User> users)
	{
		users.add(u);
	}
	
	// turns a string into a polynomial hash for storing passwords and checking them.
	private long hashCode(String str)
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
