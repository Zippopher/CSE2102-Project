package Function;

import java.util.LinkedList;

public class TEST 
{
	private static LinkedList<User> users = new LinkedList<User>();
	private static LinkedList<Restaurant> restaurants = new LinkedList<Restaurant>();
	private static User currentUser;
	
	public static void main(String[] args)
	{
		users.add(new Admin("admin", "pass"));
		users.add(new User("test1", "0123"));
		users.add(new User("test2", "abcd"));
		currentUser = users.get(0);
		
		((Admin)currentUser).addRestaurant("Rest1", restaurants); // Note that the pre-made interfacing method handles casting
		((Admin)currentUser).addRestaurant("Rest2", restaurants);
		((Admin)currentUser).addRestaurant("Place1", restaurants);
		
		
		testUsers(); // all methods are called by users at some point.
	}
	
	public static void testUsers()
	{
		for(User u : users)
		{
			System.out.print(u + ", "); // should print 3 reference values
		}
		System.out.println();
		System.out.println(currentUser); // should print one of the earlier 3 (last one)
		System.out.println();
		
		System.out.println(currentUser.verifyUser("test3", "1234", users)); // null
		System.out.println(currentUser.verifyUser("test1", "0123", users)); // first from earlier list
		System.out.println();
		
		currentUser.createReview(restaurants.get(0), 3, 3, 3, 3, "very good.");
		currentUser = currentUser.verifyUser("test2", "abcd", users);  // note that the main interfacing class sets the currentUserbased on verifyUser's return
		currentUser.createReview(restaurants.get(0), 4, 5, 2, 1, "Quite cheap");
		
		System.out.println(restaurants.get(0).getReviews().size()); // 2
		for(Review r : restaurants.get(0).getReviews()) // Should print 2 reference values
		{
			System.out.print(r + ", ");
		}
		System.out.println();
		
		Restaurant[] rests1 = currentUser.search("rest", 0, restaurants);
		Restaurant[] rests2 = currentUser.search("place", 0, restaurants);
		
		for(Restaurant r : rests1)
		{
			System.out.print(r.getName() + ", "); // Should print "rest1, rest2"
		}
		System.out.println();
		for(Restaurant r : rests2)
		{
			System.out.print(r.getName() + ", "); // Should print "place1"
		}
		
		rests1 = currentUser.search("3", 1, restaurants);
		
		System.out.println();
		System.out.println();
		
		for(Restaurant r : rests1)
		{
			System.out.print(r.getName() + ", "); // Should print "rest1"
		}
		
		System.out.println();
		System.out.println("CLEAR TEST USERS");
		System.out.println();
		
		currentUser = users.get(0); // switch to admin
		
		((Admin)currentUser).addRestaurant("Place", restaurants);
		for(Restaurant r : restaurants)
		{
			System.out.print(r.getName() + ", "); // Should print 4 names
		}
		System.out.println();
		System.out.println();
		
		((Admin)currentUser).removeRestaurant(restaurants.get(3), restaurants);
		for(Restaurant r : restaurants)
		{
			System.out.print(r.getName() + ", "); // Should print as above minus the last one
		}
		System.out.println();
		System.out.println();
		
		System.out.println(((Admin)currentUser).mineReviewsPosNeg(restaurants.get(0))); // Should be 1
		System.out.println();
		
		((Admin)currentUser).deleteReview(restaurants.get(0).getReviews().get(0));
		for(Review r : restaurants.get(0).getReviews()) // Should print the above reference values minus the first
		{
			System.out.print(r + ", ");
		}
		System.out.println();
		System.out.println();
		
		// Grant Admin needs the main client to work, as it calls the main running method to receive the list of current users
		
		System.out.println();
		System.out.println("CLEAR TEST ADMINS");
		System.out.println();
	}
}
