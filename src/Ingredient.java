

public class Ingredient {
	protected String name;
	protected String measurement;
	
	public Ingredient(String name, String measurement) {
		this.name = name;
		this.measurement = measurement;
	}
	
	public void changeName(String name) {
		this.name = name;
	}
	
	public void changeMeasurement(String measurement) {
		this.measurement = measurement;
	}
}
