import java.util.ArrayList;

public class Recipe {

	protected String name;
	protected String duration;
	protected String instructions;
	protected ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
	
	public Recipe(String name, String duration, String instructions) {
		this.name = name;
		this.duration = duration; 
		this.instructions = instructions;
	}
	
	public void addIngredient(String name, String measurement) {
		Ingredient ingredient = new Ingredient(name, measurement);
		ingredientList.add(ingredient);
	}
	
	public void changeName(String name) {
		this.name = name;
	}
	
	public void changeDuration(String duration) {
		this.duration = duration;
	}
	
	public void changeInstructions(String instructions) {
		this.instructions = instructions;
	}
	
}
