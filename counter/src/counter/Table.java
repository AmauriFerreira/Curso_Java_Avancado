package counter;

public class Table {
    private final String[] names;
    private final int[] grades;
    private int total;
    
    // invariante: os elementos da tabela estão em 
    //             names[0:total) e grades[0:total)
    //             0 <= total <= names.length
    
    public Table(int n) {
    	names = new String[n];
    	grades = new int[n];
    	total = 0;
    }
    
    private int find(String name) {
    	int i = 0;
    	while (i < total && !names[i].equals(name)) { ++i; }
    	return i;
    }
    
    public Table remove(String name) {
    	int index = find(name);
    	if (index == total) { return this; }
    	for (int i = index+1; i < total; ++i) {
    		names[i-1] = names[i];
    		grades[i-1] = grades[i];
    	}
    	--total;
    	return this;
    }
    
    public Table insert(String name, int grade) {
    	int index = find(name);
    	if (index == total && total == names.length) { return this; }
    	names[index] = name;
    	grades[index] = grade;
    	if (index == total) { ++total; }
    	return this;
    }
    
    public String[] getHigher(int grade) {
    	int n = 0;
    	for (int i = 0; i < total; ++i) {
    		if (grades[i] >= grade) { ++n; }
    	}
    	String[] nms = new String[n];
    	int k = 0;
    	for (int i = 0; i < total; ++i) {
    		if (grades[i] >= grade) {
    			nms[k++] = names[i];
    		}
    	}
    	return nms;
    }
    
    public Integer getGrade(String name) {
    	int index = find(name);
    	return index == total ? null : grades[index];
    }
    
    public String[] getNames() { 
    	String[] nms = new String[total];
    	for (int i = 0; i < total; ++i) {
    		nms[i] = names[i];
    	}
    	return nms;
    }
    
    public static void main(String[] args) {
    	Table t = new Table(50);
    	t.insert("guilherme", 8)
    	 .insert("manoel",  9)
    	 .insert("joana",  10)
    	 .insert("guilherme", 10);
    	System.out.println(t.getGrade("guilherme"));
    	t.remove("joana");
    	System.out.println(t.getGrade("joana"));
    }
}
