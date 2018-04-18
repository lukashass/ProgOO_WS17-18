package programming.set10.dna;

public class Main {
	public static void main(String[] args) {
		DNAMatcher dna = new DNAMatcher("AC");
		System.out.println(dna.findFirstBindingPosition("AT"));
	}
}
