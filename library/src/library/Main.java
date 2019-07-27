package library;

import java.time.Year;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		Library lib = new Library("Newton");
		lib.addBook(new Book("C", 
				    Arrays.asList("Kernigham", "Ritchie"), Year.of(1980), Topic.COMPUTING));
		lib.addBook(new Book("C", Arrays.asList("Deitel"), Year.of(2000), Topic.COMPUTING));
		lib.addBook(new Book("Structure and Interpretation of Computer Programs",
				    Arrays.asList("Abelson", "Sussman"), Year.of(1980), Topic.COMPUTING));
		
		lib.byTitle("C").forEach(b -> System.out.println(b));
		lib.addBook(new Book("TAOCPV1", 
			    Arrays.asList("Knuth"), Year.of(1965), Topic.COMPUTING));
		lib.addBook(new Book("TAOCPV2", 
			    Arrays.asList("Knuth"), Year.of(1965), Topic.COMPUTING));
		lib.addBook(new Book("TAOCPV3", 
			    Arrays.asList("Knuth"), Year.of(1965), Topic.COMPUTING));
		lib.addBook(new Book("TAOCPV4", 
			    Arrays.asList("Knuth"), Year.of(1965), Topic.COMPUTING));
		lib.byAuthor("Knuth").forEach(System.out::println);
		lib.allAuthors().forEach(System.out::println);
		System.out.println(lib.byYear());
	}

}
