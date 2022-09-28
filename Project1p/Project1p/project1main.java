package Project1p;
/*
 * Matt Wagers
 * OOP Java (CSCI 3381)
 * Project 1 -> Netflix Data Back End
 */
public class project1main {

	public static void main(String[] args) {
		ShowWeek sw1 = new ShowWeek();
		AllWeeks myList = new AllWeeks();
		
		// Create default Show (values set to none)
		System.out.println(sw1);
		// Create custom Show
		ShowWeek sw2 = new ShowWeek("9-12-20", "Drama", "4", "Breaking Bad", "Season 1", "72000000", "10");
		// Compare two shows
		System.out.println(sw2);
		System.out.println(sw1.equals(sw2)); //expect false
		System.out.println(sw2.equals(sw2)); //expect true
		// Create custom list of shows
		myList.addShow(sw2);
		ShowWeek sw3 = new ShowWeek("9-12-20", "Romance", "2", "Outlander", "Season 3", "4523000", "2");
		ShowWeek sw4 = new ShowWeek("9-12-20", "Drama", "1", "Do Revenge", "N/A", "42550000", "2");
		ShowWeek sw5 = new ShowWeek("9-19-20", "Action", "3", "Lou", "Season 4", "40570000", "1");
		myList.addShow(sw3);
		myList.addShow(sw4);
		myList.addShow(sw5);
		// Create random suggestion
		System.out.println(myList.ranSuggest());
		// Suggest a show other than input (Outlander)
		System.out.println(myList.predictiveSuggest("Outlander")); //Suggestion should not contain Outlander
		// Purge Breaking Bad from being suggested
		myList.purge("Breaking Bad");
		System.out.println(myList.predictiveSuggest("Outlander")); //Suggestion should not contain Outlander || Breaking Bad
		// Unpurge Breaking Bad and can now be suggested again
		myList.unPurge("Breaking Bad");
		System.out.println(myList.predictiveSuggest("Outlander")); //Suggestion should not contain Outlander
		// Create custom list of input date(week)
		String myWeekList = myList.getShowsinWeek("9-12-20");
		System.out.println(myWeekList);
		// Create ArrayList of data from txt file
		AllWeeks allData = new AllWeeks("AllShows", "netflixAllWeeksGlobalProcessed.txt");
		// Create custom list of shows from specific date(week)
		// Test for large data
		myWeekList = allData.getShowsinWeek("2021-09-26");
		System.out.println(myWeekList);
		// Test purge on allData
		allData.purge("The Circle");
		System.out.println(allData.predictiveSuggest("Good Girls"));
		// Edit a show. Call the setter for data to be changed
		sw5.setCategory("Drama");
		System.out.println(sw5);
		// Write to a new file with my custom list
		myList.writeFile("./Project1p/testfile.txt");

		

		
	}

}
