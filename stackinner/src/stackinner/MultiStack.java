package stackinner;

import java.util.Iterator;

public class MultiStack<T> implements AbsStack<T>, Iterable<T> {
	private Stack<T> stack = new Stack<>();
	
	public Iterator<T> iterator() {
		return stack.iterator();
	}
	
	public boolean empty() {
		return stack.empty();
	}
	
	public void push(T obj) {
		stack.push(obj);
	}
	
	public void pop() {
		stack.pop();
	}
	
	public T top() { return stack.top(); }
	
	public void multipush(Iterable<T> col) {
		for (T obj: col) {
			stack.push(obj);
		}
	}
	
	public void multipop(int k) {
		for (int i = 1; i <= k && !stack.empty(); ++i) {
			stack.pop();
		}
	}
		
    // Exercicio: Escreva uma versao usando um iterador
	// para popular a pilha destino
	public Iterator<T> multitop(int k) {
		Stack<T> dep = new Stack<>();
		for (int i = 1; i <= k && !stack.empty(); ++i) {
			dep.push(stack.top());
			stack.pop();
		}
		for (T obj: dep) {
			stack.push(obj);
		}
		return dep.reverseIterator();
	}
	

}
