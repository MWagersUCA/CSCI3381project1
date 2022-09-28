package Project1p;

import java.util.Objects;

public class ShowWeek {
	private String week;
	private String category;
	private String weekly_rank;
	private String show_titles;
	private String season_title;
	private String weekly_hours_viewed; 
	private String cumulative_weeks_in_top10;
	
	
	public ShowWeek() {
		week = "none";
		category = "none";
		weekly_rank = "none";
		show_titles = "none";
		season_title = "none";
		weekly_hours_viewed = "none";
		cumulative_weeks_in_top10 = "none";
	}
	
	
	public ShowWeek(String week, String category, String weekly_rank, String show_titles, String season_title,
			String weekly_hours_viewed, String cumulative_weeks_in_top10) {
		super();
		this.week = week;
		this.category = category;
		this.weekly_rank = weekly_rank;
		this.show_titles = show_titles;
		this.season_title = season_title;
		this.weekly_hours_viewed = weekly_hours_viewed;
		this.cumulative_weeks_in_top10 = cumulative_weeks_in_top10;
	}
	
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getWeekly_rank() {
		return weekly_rank;
	}
	public void setWeekly_rank(String weekly_rank) {
		this.weekly_rank = weekly_rank;
	}
	public String getShow_titles() {
		return show_titles;
	}
	public void setShow_titles(String show_titles) {
		this.show_titles = show_titles;
	}
	public String getSeason_title() {
		return season_title;
	}
	public void setSeason_title(String season_title) {
		this.season_title = season_title;
	}
	public String getWeekly_hours_viewed() {
		return weekly_hours_viewed;
	}
	public void setWeekly_hours_viewed(String weekly_hours_viewed) {
		this.weekly_hours_viewed = weekly_hours_viewed;
	}
	public String getCumulative_weeks_in_top10() {
		return cumulative_weeks_in_top10;
	}
	public void setCumulative_weeks_in_top10(String cumulative_weeks_in_top10) {
		this.cumulative_weeks_in_top10 = cumulative_weeks_in_top10;
	}
	public String toString() {
		return week + " " +category+ " " +weekly_rank+ " " +show_titles+ " " +season_title+ " " +weekly_hours_viewed+ " " +cumulative_weeks_in_top10;
	}
	public boolean equals(Object o) {
		ShowWeek sw = (ShowWeek)o;
		String compare = getWeek() + getShow_titles();
		String compare2 = sw.getWeek() + sw.getShow_titles();
		return compare.equals(compare2);
	}
	

}
