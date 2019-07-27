package library;

import java.time.Year;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Book {
	private String title;
	private List<String> authors;
	private Year year;
	private Topic topic;
	
	public String getTitle() {
		return title;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", authors=" + authors + ", year=" + year + ", topic=" + topic + "]";
	}
	public Stream<String> getAuthors() {
		return authors.stream();
	}
	public Year getYear() {
		return year;
	}
	public Topic getTopic() {
		return topic;
	}
	
	public Book(String title, List<String> authors, Year year, Topic topic) {
		this.title = title; this.authors = Collections.unmodifiableList(authors); 
		this.year = year; this.topic = topic; 
	}
	 
}
