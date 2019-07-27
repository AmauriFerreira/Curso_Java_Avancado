package stackinner;

import java.util.Iterator;

public class Main {
	
	public static void main(String[] args) {
		int[] xs = { 2, 3, 1, 5, 7, 8 };
		MultiStack<Integer> stack = new MultiStack<>();
		for (int x : xs) {
			stack.push(x);
		}
		Iterator<Integer> it = stack.multitop(3);
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
		for (int x: stack) {
			System.out.println(x);
		}
		/*Iterator<Integer> it = stack.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
	    } */
		System.out.println();
		
		MultiStackInh<Integer> stackinh = new MultiStackInh<>();
		for (int x : xs) {
			stackinh.push(x);
		}
		Iterator<Integer> it2 = stackinh.multitop(3);
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
		System.out.println();
		for (int x: stackinh) {
			System.out.println(x);
		}
		/*Iterator<Integer> it = stack.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
	    } */
		System.out.println();
		
	}

}
