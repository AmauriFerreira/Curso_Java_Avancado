package fjex;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Sum extends RecursiveTask<Long> {
	private final long[] vec;
	private final int start;
	private final int finish;
	private final int THRESHOLD = 5;
	
	public Sum(long[] vec, int start, int finish) {
		this.vec = vec; this.start = start; this.finish = finish;
	}
	
	private long dirSum() {
		long s = 0;
		for (int i = start; i != finish; ++i) s += vec[i];
		return s;
	}
	
	public Long compute() {
		if (finish - start < THRESHOLD) return dirSum();
		int m = (start + finish) / 2;
		Sum left = new Sum(vec, start, m);
		Sum right = new Sum(vec, m, finish);
		left.fork(); right.fork();
		long x = left.join();
		long y = right.join();
		return x + y;
	}
		
	public static long sum(long[] vec) {
		ForkJoinPool pool = new ForkJoinPool();
		Sum root = new Sum(vec, 0, vec.length);
		pool.invoke(root);
		return root.join();
	}
	
	public static void main(String[] args) {
		long[] xs = { 1, 2, 4, 5, 7, 8, 9, 10, 3, 6 };
		System.out.println(sum(xs));
	}

}
