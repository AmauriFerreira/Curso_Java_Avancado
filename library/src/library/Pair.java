package library;

public class Pair<T, U> {
	public final T fst;
	public final U snd;
	Pair(T fst, U snd) { this.fst = fst; this.snd = snd; }
	public String toString() { return "(" + fst + ", " + snd + ")"; }
}
