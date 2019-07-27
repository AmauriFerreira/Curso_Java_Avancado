package counter;

public class Counter {
	public final int initial;
	private int current;
	
	// invariante: current >= initial
	
	public Counter(int initial) {
		this.current = this.initial = initial;
	}
	
	public Counter inc() { ++current; return this; }
	public Counter dec() {
		if (current > initial) {
			--current;
		}
		return this;
	}
	
	public int current() { return current; }
	
	public static void main(String[] args) {
		Counter c = new Counter(10);
		c.inc().inc();
		c.inc();
	}

}
