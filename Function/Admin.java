package Function;

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
		Main.deleteReview(review);
	}
	
	// make a review visible/invisible pending review
	public void hideReview(Review review)
	{
		Main.hideReview(review, true);
	}
	public void unhideReview(Review review)
	{
		Main.hideReview(review, false);
	}
	
	// add a new restaurant to the list
	public void addRestarant(String name)
	{
		Main.addRestaurant(new Restaurant(name));
	}
	
	// remove a restaurant from the list
	public void removeRestaurant(Restaurant rest)
	{
		Main.removeRestaurant(rest);
	}
	
	// mine reviews for a given restaurant to find pos/neg or hints towards slander
	public int mineReviewsPosNeg(Restaurant rest)
	{
		return Main.retrPosNeg(rest);
	}
	public Review[] mineReviewsOutliers(Restaurant rest)
	{
		return Main.findOutliers(rest);
	}
}
