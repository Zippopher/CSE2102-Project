package Function;

public class Review 
{
	private Restaurant restaurant;
	private int overallRating;
	private int foodRating;
	private int serviceRating;
	private int priceRating;
	private User author;
	private String review;
	private boolean hidden = false;
	
	// base constructor
	public Review()
	{}
	
	// general constructor
	public Review(Restaurant rest, int oRate, int fRate, int sRate, int pRate, User auth, String rev)
	{
		restaurant = rest;
		overallRating = oRate;
		foodRating = fRate;
		serviceRating = sRate;
		priceRating = pRate;
		author = auth;
		review = rev;
		rest.addReview(this);
	}
	
	// method to update hidden status
	public void hide(boolean isHidden)
	{
		hidden = isHidden;
	}
	
	// accessors
	public int getOverallRating()
	{
		return overallRating;
	}
	public int getFoodRating()
	{
		return foodRating;
	}
	public int getServiceRating()
	{
		return serviceRating;
	}
	public int getPriceRating()
	{
		return priceRating;
	}
	public Restaurant getRestaurant()
	{
		return restaurant;
	}
	public User getAuthor()
	{
		return author;
	}
	public boolean getHidden()
	{
		return hidden;
	}
}
