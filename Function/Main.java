package Function;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main 
{
	private static LinkedList<User> users;
	private static LinkedList<Restaurant> restaurants;
	private static User currentUser;
	
	public static void main(String[] args)
	{
		// Anonymous user and base admin for starting
		users.add(new User("anon", ""));
		users.add(new Admin("admin", "password"));
		currentUser = users.get(0);
	}
	
	// A Login Method
	public static boolean verifyUser(String name, String pass)
	{
		long hash = currentUser.hashCode(pass);
		for(User u : users)
		{
			if(u.getUsername().equals(name) && u.getPassword() == hash)
				return true;
		}
		return false;
	}
	
	// Search Methods to interact with the List
	public static Restaurant[] searchName(String name)
	{
		ArrayList<Restaurant> results = new ArrayList<Restaurant>();
		for(Restaurant r : restaurants)
		{
			if(r.getName().contains(name))
				results.add(r);
		}
		return results.toArray(new Restaurant[results.size()]);
	}
	public static Restaurant[] searchRate(double rate)
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
	public static Restaurant[] searchPrice(double price)
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
	
	// Data Mining
	public static int retrPosNeg(Restaurant rest)
	{
		return rest.isPosNeg();
	}
	public static Review[] findOutliers(Restaurant rest)
	{
		LinkedList<Review> reviews = rest.getReviews();
		
	}
	
	// User Manipulation
	public static void addUser(User user)
	{
		users.add(user);
	}
	public static void removeUser(User user)
	{
		users.remove(user);
	}
	
	// Review Manipulation
	public static void deleteReview(Review review)
	{
		Restaurant rest = review.getRestaurant();
		rest.getReviews().remove(review);
	}
	public static void hideReview(Review review, boolean isHidden)
	{
		review.hide(isHidden);
	}
	
	// Restaurant Manipulation
	public static void addRestaurant(Restaurant rest)
	{
		restaurants.add(rest);
	}
	public static void removeRestaurant(Restaurant rest)
	{
		users.remove(rest);
	}
	
}
