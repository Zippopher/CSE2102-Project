package Function;

import java.util.LinkedList;

public class Admin extends User
{
	// base constructor
	public Admin()
	{
		super();
	}
	
	// general constructor
	public Admin(String name, String pass)
	{
		super(name, pass);
	}
	
	// Private constructor to turn a user into an admin
	private Admin(String name, long pass)
	{
		super();
		super.setUsername(name);
		super.setPassword(pass);
	}
	
	// turn a user into an admin
	public void grantAdmin(User user)
	{
		String name = user.getUsername();
		long pass = user.getPassword();
		
		Main.removeUser(user);
		Main.addUser(new Admin(name, pass));
	}
	
	// delete unsavory reviews
	public void deleteReview(Review review)
	{
		review.getRestaurant().getReviews().remove(review);
	}
	
	// make a review visible/invisible pending review
	public void hideReview(Review review, boolean isHidden)
	{
		review.hide(isHidden);
	}
	
	// add a new restaurant to the list
	public void addRestaurant(String name, LinkedList<Restaurant> restaurants)
	{
		restaurants.add(new Restaurant(name));
	}
	
	// remove a restaurant from the list
	public void removeRestaurant(Restaurant rest, LinkedList<Restaurant> restaurants)
	{
		restaurants.remove(rest);
	}
	
	public void removeUser(User u, LinkedList<User> users)
	{
		users.remove(u);
	}
	
	// mine reviews for a given restaurant to find pos/neg or hints towards slander
	public int mineReviewsPosNeg(Restaurant rest)
	{
		return rest.isPosNeg();
	}
	/*
	public Review[] mineReviewsOutliers(Restaurant rest)
	{
		return Main.findOutliers(rest);
	}
	*/
}
