package stackinner;

public interface AbsStack<T> {
	public void push(T x);
	// pre-condicao: !empty()
	public T top();
	// pre-condicao: !empty()
	public void pop();
	public boolean empty();
}
