package Project1p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class AllWeeks {
	private ArrayList<ShowWeek> shows;
	private ArrayList<String> purgedShows;
	private String listName;
	private String fileName;


	public AllWeeks() {
		shows = new ArrayList<ShowWeek>();
		purgedShows = new ArrayList<String>();
		listName = "a name";
		fileName = null;
	}

	public AllWeeks(String ln, String fn) {
		this();
		listName = ln;
		fileName = fn;
		readFile();
	}

	public void addShow(ShowWeek s) {
		shows.add(s);
	}

	public String toString() {
		String toReturn = listName + ":\n";
		for(ShowWeek s: shows) {
			toReturn += s.toString() + "\n";
		}
		return toReturn;
	}

	public void purge(String s) {
		purgedShows.add(s);
	}
	public void unPurge(String s) {
		if(purgedShows.contains(s)) {
			purgedShows.remove(s);
		}
		else {
			System.out.println("Unable to locate:  " + s);
		}
	}
	public boolean isPurged(String s) {
		if(purgedShows.contains(s)) {
			return true;
		}
		return false;
	}

	public String ranSuggest() {
		int index = (int) (Math.random() * shows.size());
		return shows.get(index).getShow_titles();
	}
	public String predictiveSuggest(String s) {
		String toReturn = ranSuggest();
		while(toReturn == s || isPurged(toReturn)) {
			toReturn = ranSuggest();
		}
		return toReturn;
	}

	public String getShowsinWeek(String s) {
		String toReturn = "Shows in selected week:\n";
		for(ShowWeek sw : shows) {
			if(sw.getWeek().equals(s)) {
				toReturn += sw.getShow_titles() + "\n";
			}
		}
		return toReturn;
	}

	private void readFile () {
		BufferedReader lineReader = null;
		try {
			FileReader fr = new FileReader(fileName);
			lineReader = new BufferedReader(fr);
			String week = null;
			while ((week = lineReader.readLine())!=null) {
				String category = lineReader.readLine();
				String weekly_rank = lineReader.readLine();
				String show_titles = lineReader.readLine();
				String season_title = lineReader.readLine();
				String weekly_hours_viewed = lineReader.readLine();
				String cumulative_weeks_in_top10 = lineReader.readLine();
				addShow(new ShowWeek(week, category, weekly_rank, show_titles, season_title, weekly_hours_viewed, cumulative_weeks_in_top10));

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("there was a problem with the file reader, try different read type.");
			try {
				lineReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(fileName.substring(1))));
				String week = null;
				while ((week = lineReader.readLine())!=null) {
					String category = lineReader.readLine();
					String weekly_rank = lineReader.readLine();
					String show_titles = lineReader.readLine();
					String season_title = lineReader.readLine();
					String weekly_hours_viewed = lineReader.readLine();
					String cumulative_weeks_in_top10 = lineReader.readLine();
					addShow(new ShowWeek(week, category, weekly_rank, show_titles, season_title, weekly_hours_viewed, cumulative_weeks_in_top10));

				}
			} catch (Exception e2) {
				System.err.println("there was a problem with the file reader, try again.  either no such file or format error");
			} finally {
				if (lineReader != null)
					try {
						lineReader.close();
					} catch (IOException e2) {
						System.err.println("could not close BufferedReader");
					}
			}			
		} finally {
			if (lineReader != null)
				try {
					lineReader.close();
				} catch (IOException e) {
					System.err.println("could not close BufferedReader");
				}
		}
	} // end of readFile method	

	public void writeFile () {
		// overloaded method: this calls doWrite with file used to read data
		// use this for saving data between runs
		doWrite(fileName);
	} // end of writeFile method

	public void writeFile(String altFileName) {
		// overloaded method: this calls doWrite with different file name 
		// use this for testing write
		doWrite(altFileName);		
	}// end of writeFile method

	private void doWrite(String fn) {
		// this method writes all of the data in the persons array to a file
		try
		{

			FileWriter fw = new FileWriter(fn);
			BufferedWriter myOutfile = new BufferedWriter(fw);			

			for(ShowWeek sw : shows) {
				myOutfile.write (sw.getWeek() + "\n");
				myOutfile.write (sw.getCategory() + "\n");
				myOutfile.write (sw.getWeekly_rank() + "\n");
				myOutfile.write (sw.getShow_titles() + "\n");
				myOutfile.write (sw.getSeason_title() + "\n");
				myOutfile.write (sw.getWeekly_hours_viewed() + "\n");
				myOutfile.write (sw.getCumulative_weeks_in_top10() + "\n");
			}

			myOutfile.flush();
			myOutfile.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Didn't save to " + fn);
		}
	}	

}
