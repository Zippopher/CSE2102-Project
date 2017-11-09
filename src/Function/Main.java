package Function;

import java.util.LinkedList;

public class Main 
{
	private static LinkedList<User> users = new LinkedList<User>();
	private static LinkedList<Restaurant> restaurants = new LinkedList<Restaurant>();
	private static User currentUser;
	
	public static void main(String[] args)
	{
		// Anonymous user and base admin for starting
		users.add(new User("anon", ""));
		users.add(new Admin("admin", "password"));
		currentUser = users.get(0);
		
		restaurants.add(new Restaurant("rest1"));
		restaurants.add(new Restaurant("rest2"));
		
		userInterface.NEW_UI.main(args);
	}
	
	// A Login Method
	public static boolean verifyUser(String name, String pass)
	{
		User user = currentUser.verifyUser(name, pass, users);
		if(user == null)
			return false;
		else
			currentUser = user;
		return true;
				
	}
	public static void logout()
	{
		currentUser = users.getFirst();
	}
	
	public static Restaurant[] search(String term, int type)
	{
		return currentUser.search(term, type, restaurants);
	}
	
	// Data Mining
	public static int retrPosNeg(Restaurant rest)
	{
		if(currentUser instanceof Admin)
		{
			return ((Admin)currentUser).mineReviewsPosNeg(rest);
		}
		return 0;
	}
	
	/* To add later
	public static Review[] findOutliers(Restaurant rest)
	{
		LinkedList<Review> reviews = rest.getReviews();
		
	}
	*/
	
	// User Manipulation
	public static void addUser(User user)
	{
		currentUser.addUser(user, users);
		currentUser = user;
	}
	public static void removeUser(User user)
	{
		if(currentUser instanceof Admin && !(currentUser.equals(user)))
		{
			((Admin)currentUser).removeUser(user, users);
		}
	}
	
	// Review Manipulation
	public static boolean deleteReview(Review review)
	{
		if(currentUser instanceof Admin)
		{
			((Admin)currentUser).deleteReview(review);
			return true;
		}
		return false;
	}
	public static boolean hideReview(Review review, boolean isHidden)
	{
		if(currentUser instanceof Admin)
		{
			((Admin)currentUser).hideReview(review, isHidden);
			return true;
		}
		return false;
	}
	
	// Restaurant Manipulation
	public static boolean addRestaurant(String name)
	{
		if(currentUser instanceof Admin)
		{
			((Admin)currentUser).addRestaurant(name, restaurants);
			return true;
		}
		return false;
	}
	public static boolean removeRestaurant(Restaurant rest)
	{
		if(currentUser instanceof Admin)
		{
			((Admin)currentUser).removeRestaurant(rest, restaurants);
			return true;
		}
		return false;
	}
	
	public static void addReview(Review rev)
	{
		restaurants.get(findRest(rev.getRestaurant())).addReview(rev);
	}
	
	private static int findRest(Restaurant rest)
	{
		for(int i = 0; i < restaurants.size(); i++)
		{
			if(restaurants.get(i).getName().equals(rest.getName()))
				return i;
		}
		return -1;
	}
	
	public static Restaurant[] getRestaurants()
	{
		return restaurants.toArray(new Restaurant[restaurants.size()]);
	}
	public static User getCurrentUser()
	{
		return currentUser;
	}
	
}
