package library;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Library {
	public final String name;
	private final List<Book> library;
	
	public Library(String name) {
		this.name = name;
		library = new ArrayList<>();
	}
	
	public void addBook(Book b) { library.add(b); }
	
	public Stream<Book> byTitle(String title) {
		return library.stream()
				      .filter((Book b) -> b.getTitle().equals(title));
	}
	
	public Stream<Book> byAuthor(String name) {
		return library.stream()
				      .filter(b -> b.getAuthors()
				    		        .collect(Collectors.toList())
				    		        .contains(name));
	}
	
	public Map<String, List<Book>> byAuthors() {
		List<Pair<String, Stream<Book>>> 
		list = allAuthors().map(name -> new Pair<>(name, byAuthor(name)))
				          .collect(Collectors.toList());
		Map<String, List<Book>> byAuthors = new HashMap<>();
		for (Pair<String, Stream<Book>> p: list) {
			byAuthors.put(p.fst, p.snd.collect(Collectors.toList()));
		}
		return byAuthors;
	}
	
	public Stream<String> allAuthors() {
		return library.stream()
				      .flatMap(b -> b.getAuthors())
				      .distinct()
				      .sorted();
	}
	
	public Map<Year, List<Book>> byYear() {
		return library.stream()
				      .collect(Collectors.groupingBy((Book b) -> b.getYear()));
	}
	public List<Book> oldWayByTitle(String title) {
		List<Book> result = new ArrayList<>();
		for (Book b: library) {
			if (b.getTitle().equals(title)) { result.add(b); }
		}
		return result;
	}
		
	
	

}

