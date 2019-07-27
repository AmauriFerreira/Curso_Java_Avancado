package gen;

public class Box<T> {
    private T contents;
    public Box(T initial) { contents = initial; }
    public T get() { return contents; }
    public void update(T newc) { contents = newc; }
    
    public static void main(String[] args) {
    	Box<String> box = new Box<>("maria");
    	System.out.println(box.get());
    	box.update("joao");
    	System.out.println(box.get());
    	Box<Integer> bi = new Box<>(10);
    	int x = bi.get();
    	System.out.println(x);
    }
}
