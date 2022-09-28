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
		
		System.out.println(sw1);
		ShowWeek sw2 = new ShowWeek("9-12-20", "Drama", "4", "Breaking Bad", "Season 1", "72000000", "10");
		System.out.println(sw2);
		System.out.println(sw1.equals(sw2)); //expect false
		System.out.println(sw2.equals(sw2)); //expect true
		
		myList.addShow(sw2);
		ShowWeek sw3 = new ShowWeek("9-12-20", "Romance", "2", "Outlander", "Season 3", "4523000", "2");
		ShowWeek sw4 = new ShowWeek("9-12-20", "Drama", "1", "Do Revenge", "N/A", "42550000", "2");
		ShowWeek sw5 = new ShowWeek("9-19-20", "Action", "3", "Lou", "Season 4", "40570000", "1");
		myList.addShow(sw3);
		myList.addShow(sw4);
		myList.addShow(sw5);
		System.out.println(myList.ranSuggest());
		System.out.println(myList.predictiveSuggest("Outlander")); //Suggestion should not contain Outlander
		myList.purge("Breaking Bad");
		System.out.println(myList.predictiveSuggest("Outlander")); //Suggestion should not contain Outlander || Breaking Bad
		myList.unPurge("Breaking Bad");
		System.out.println(myList.predictiveSuggest("Outlander")); //Suggestion should not contain Outlander
		
		String myWeekList = myList.getShowsinWeek("9-12-20");
		System.out.println(myWeekList);
		
		AllWeeks allData = new AllWeeks("AllShows", "netflixAllWeeksGlobalProcessed.txt");
		myWeekList = allData.getShowsinWeek("2021-09-26");
		System.out.println(myWeekList);
		allData.purge("The Circle");
		System.out.println(allData.predictiveSuggest("Good Girls"));
		
		myList.writeFile("./Project1p/testfile.txt");
		//System.out.println(allData);
		//allData.addShow(sw1);
		//allData.addShow(sw2);
		//System.out.println(allData);
		//System.out.println(allData.ranSuggest());
		

		
	}

}
