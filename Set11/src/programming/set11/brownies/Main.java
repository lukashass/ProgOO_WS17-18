package programming.set11.brownies;

public class Main {
	public static void main(String[] args) {
		BrownieMap<Integer, String> brown;

		brown = new BrownieMap<>(4);
		brown.put(2, "123s");
		brown.put(6, "20s");
		System.out.println(brown.get(2));
		System.out.println(brown.get(6));
		brown.remove(6);
		System.out.println(brown.get(2));
		System.out.println(brown.get(6));

	}
}
