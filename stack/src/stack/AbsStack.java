package stack;

public interface AbsStack<T> {
	public void push(T x);
	// pre-condicao: !empty()
	public T top();
	// pre-condicao: !empty()
	public void pop();
	public boolean empty();
	public T[] elems();
}

// s: AbsStack
// x, y: T
// s.push(x)
// y = s.top()
// x == y é verdadeiro

// s.push(x)
// s.empty() é falso

// suponha que t é uma copia de s
// s.push(x)
// s.pop()
// t e s são iguais

// cada nova instancia t satisfaz t.empty() é verdadeiro

// n = s.size()
// s.push(x)
// m = s.size()
// m == n+1 é verdadeiro

// toda pilha é equivalente a uma pilha da forma
// p1 = empty.push(x1)
// p2 = p1.push(x2)
// ... pn = pn_1.push(xn)
// pn.elems() devolve o vetor [xn, xn_1, ..., x1] 
