package stackinner;

import java.util.Iterator;

class EmptyStackException extends RuntimeException {
    public EmptyStackException(String str) { super(str); }	
}

public class Stack<T> implements AbsStack<T>, Iterable<T> {
	private T[] elems;
	private int idxtop;
	
	// invariante: 0 <= top <= elems.length
	// a "pilha" está armazenda em elems[0:top)
	
	private static class StackIt<T> implements Iterator<T> {
		private Stack<T> me;
		private int current;
		
		public StackIt(Stack<T> me)  {
            this.me = me;   
            current = me.idxtop;
		}
		
		public boolean hasNext() {
			return current > 0;
		}
		
		// hasNext() == true
		public T next() {
			--current;
			return me.elems[current];
		}
	}
	
	public static class StackRev<T> implements Iterator<T> {
		private Stack<T> me;
		private int current;
		
		public StackRev(Stack<T> me) {
			this.me = me;
			current = 0;
		}
		
		public boolean hasNext() {
			return current < me.idxtop;
		}
		
		public T next() {
			return me.elems[current++];
		}
		
	}
	
	public Iterator<T> reverseIterator() {
		return new StackRev<T>(this);
	}
	
	public Iterator<T> iterator() { return new StackIt<T>(this); }
	
	private void ensureCap() {
		if (idxtop < elems.length) return;
		T[] newelems = (T[]) new Object[2*elems.length];
		for (int i = 0; i < elems.length; ++i) {
			newelems[i] = elems[i];
			elems[i] = null;
		}
		elems = newelems;
	}
		
	public Stack() {
		elems = (T[]) new Object[1];
		idxtop = 0;
	}
	
	public boolean empty() { return idxtop == 0; }
	
	public int size() { return idxtop; }
	// pre-condicao: !empty()
	public void pop() {
		if (empty()) throw new EmptyStackException("Stack.pop");
		--idxtop;
	}
	
	// pre-condicao: !empty()
	public T top() {
		if (empty()) throw new EmptyStackException("Stack.top");
        return elems[idxtop-1];	
	}
	
	public void push(T x) {
		ensureCap();
		elems[idxtop++] = x;
	}
 	
	public T[] elems() {
		T[] copy = (T[]) new Object[idxtop];
		for (int i = 0; i < idxtop; ++i) {
			copy[idxtop-1-i] = elems[i];
		}
		return copy;
	}
	
	public static void main(String[] args) {
		int[] xs = { 2, 3, 1, 5, 7, 8 };
		Stack<Integer> stack = new Stack<>();
		for (int x : xs) {
			stack.push(x);
		}
		for (int x: stack) {
			System.out.println(x);
		}
		/*Iterator<Integer> it = stack.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
	    } */
		Iterator<Integer> rit = stack.reverseIterator();
		while (rit.hasNext()) {
			System.out.println(rit.next());
		}
	}
}	


