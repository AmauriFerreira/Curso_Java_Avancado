package stackinner;

import java.util.Iterator;

public class MultiStackInh<T> extends Stack<T> {
	public void multipush(Iterable<T> col) {
		for (T obj: col) {
			push(obj);
		}
	}
	
	public void multipop(int k) {
		for (int i = 1; i <= k && !empty(); ++i) {
			pop();
		}
	}
		
    // Exercicio: Escreva uma versao usando um iterador
	// para popular a pilha destino
	public Iterator<T> multitop(int k) {
		Stack<T> dep = new Stack<>();
		for (int i = 1; i <= k && !empty(); ++i) {
			dep.push(top());
			pop();
		}
		for (T obj: dep) {
			push(obj);
		}
		return dep.reverseIterator();
	}
}
