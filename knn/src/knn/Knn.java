package knn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Pair<T, U> {
	public final T fst;
	public final U snd;
	Pair(T fst, U snd) { this.fst = fst; this.snd = snd; }
	public String toString() { return "(" + fst + ", " + snd + ")"; }
}

public class Knn {
	
	public static List<Pair<String, Integer>> 
	knnFit(int k, List<Double> sample, List<Pair<String, List<Double>>> data) {
		Function<List<Double>, Double> distToSample = xs -> {
			double d = 0;
			for (int i = 0; i < sample.size(); ++i) {
				double dx = (sample.get(i) - xs.get(i));
				d += dx * dx;
			}
			return d;
		};
		return
		data.parallelStream()
		    .map(p -> new Pair<>(p.fst, distToSample.apply(p.snd)))
		    .sorted(Comparator.comparing(p -> p.snd))
		    .limit(k)
		    .collect(Collectors.groupingBy(p -> p.fst))
		    .entrySet()
		    .stream()
		    .map(e -> new Pair<String, Integer>(e.getKey(), e.getValue().size()))
		    .sorted(Comparator.comparing(p -> -p.snd))
		    .collect(Collectors.toList());
	}
	
	public static List<Pair<String, List<Double>>> readData() {
		List<Pair<String, List<Double>>> data = new ArrayList<>();
		try (BufferedReader 
		rd = new BufferedReader(new FileReader("/home/fatec/Downloads/iris.txt"))) {
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				String[] inf = line.split(",");
				List<Double> rep = new ArrayList<>();
				for (int i = 0; i != 4; ++i) {
					rep.add(Double.parseDouble(inf[i]));
				}
				data.add(new Pair<String, List<Double>>(inf[4], rep));
				
			}
		} catch (IOException e) { e.printStackTrace(); }
		return data;
	}
	
	
	public static void main(String[] args) {
		List<Pair<String, List<Double>>> data = readData();
		
		System.out.println(knnFit(8, data.get(126).snd, data));
		/*List<Integer> xs = new ArrayList<>(
				Arrays.asList(2, 5, 1, 6, 7, 8, 10, 3, 4, 9));
		System.out.println(xs.stream()
		                     .map(x -> x*x)
		                     .filter(x -> x > 14)
		                     .sorted()
		                     .collect(Collectors.toList()));*/
	}

}
