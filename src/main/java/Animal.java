
public class Animal {

	private String name;
	private double probability;
	
	public Animal(String name, double probability) {
		this.name = name;
		this.probability = probability;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getProbability() {
		return probability;
	}
	public void setProbability(double probability) {
		this.probability = probability;
	}
}
