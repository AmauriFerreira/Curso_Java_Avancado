package gen;

public class Pair<T, U> {
	public final T first;
	public final U second;
    public Pair(T fst, U snd) {
    	first = fst;
    	second = snd;
    }
    
    public static void main(String[] args) {
    	Pair<Integer, String> p = new Pair<>(10, "maria");
    	System.out.println(p.first);
    }
}
