package exc;

class NullArgumentException extends RuntimeException {
	public NullArgumentException(String str) {
		super(str);
	}
}

class NegativeArgumentException extends RuntimeException {
	public NegativeArgumentException(String str) {
		super(str);
	}
}

class NotFoundException extends Exception { }

public class ExExc {
	
	public static int search(int x, int[] v) throws NotFoundException {
		if (v == null) throw new NullArgumentException("search v is null");
		for (int i = 0; i < v.length; ++i) {
			if (v[i] == x) {
				return i;
			}
		}
		throw new NotFoundException();
	}
	
	public static int fact(int n) throws NegativeArgumentException {
		if (n < 0) throw new NegativeArgumentException("ExExc.fact " + n);
		int fact = 1;
		for (int i = 2; i <= n; ++i) {
			fact *= i;
		}
		return fact;
	}
	
	public static int foo(int x, int [] v) throws NotFoundException {
		return search(x, v);
	}
	
	// Aqui nao se deve estender a funcap bsearch para que ela
	// seja total! O consumo de tempo para verificar que v está
	// ordenado é assintoticamente maior que o da busca binária!!!
	public static int bsearch(int x, int [] v) throws NotFoundException {
		if (v == null) throw new NullArgumentException("search v is null");
		int start = 0, finish = v.length;
		while (start != finish) {
			int m = (start + finish) / 2;
			if (v[m] == x) { return m; }
			if (x < v[m]) { finish = m; }
			else { start = m + 1; }
		}
		throw new NotFoundException();
	}
	
	public static void main(String[] args) {
		int [] v = {4, 5, 6, 1, 8, 9, 12 };
		try {
			int i = search(3, v);
		} catch (NotFoundException e) {
			System.out.println("blabla");
		}
	}

}
