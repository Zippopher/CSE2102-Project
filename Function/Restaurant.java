package Function;

import java.util.LinkedList;

public class Restaurant 
{
	private String name;
	private int isPosNeg = 0; // -1(neg), 0(neut), 1(pos)
	private double avgPrice = 0;
	private double avgRate = 0;
	
	private LinkedList<Review> reviews = new LinkedList<Review>();
	
	// base constructor
	public Restaurant()
	{}
	
	// general constructor
	public Restaurant(String name)
	{
		this.name = name;
	}
	
	// add a review to the list
	public void addReview(Review review)
	{
		reviews.add(review);
		double totPrice = 0;
		double totRate = 0;
		
		for(Review r : reviews)
		{
			totPrice += r.getPriceRating();
			totRate += r.getOverallRating();
		}
		
		avgPrice = totPrice/reviews.size();
		avgRate = totRate/reviews.size();
		
		isPosNeg();
	}
	
	// delete a review at the behest of an admin
	public void removeReview(Review review)
	{
		reviews.remove(review);
	}
	
	// mutator for when the admin runs mining
	public int isPosNeg()
	{
		int pos = 0;
		int neut = 0;
		int neg = 0;
		
		for(Review r : reviews)
		{
			if(r.getOverallRating() > 3)
				pos++;
			else if(r.getOverallRating() == 3)
				neut++;
			else
				neg++;
		}
		
		if(pos > neg && pos >= neut) // more positive than negative and at least as positive as neutral
		{
			isPosNeg = 1;
			return 1;
		}
		else if(neg > pos && neg >= neut)
		{
			isPosNeg = -1;
			return -1;
		}
		else
		{
			isPosNeg = 0;
			return 0;
		}
	}
	
	// accessors
	public int getIsPosNeg()
	{
		return isPosNeg;
	}
	public String getName()
	{
		return name;
	}
	public double getAvgPrice()
	{
		return avgPrice;
	}
	public double getAvgRate()
	{
		return avgRate;
	}
	public LinkedList<Review> getReviews()
	{
		return reviews;
	}
}
