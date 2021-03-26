import java.util.ArrayList;
import java.util.Scanner;

public class App {

	protected ArrayList<Recipe> recipeList = new ArrayList<Recipe>();

	public static void start() {
	    System.out.println("-----------------------");
	    System.out.println("Welcome to the Recipe Book! To begin, choose whether you would like to view, add, or delete recipes.");
	    Scanner key = new Scanner(System.in);
	    String choice;
	    boolean correct = false;

	    do {
		    System.out.println("Choose VIEW, ADD, or DELETE.");
	    	choice = key.nextLine();
	    	if (choice.equals("ADD") || choice.equals("DELETE") || choice.equals("VIEW")) {
	    		correct = true;
	    	} else {
	    		System.out.println("Incorrect choice.");
	    	}
	    } while (correct == false);
	    
	    key.close();
	    
	    if (choice.equals("ADD")) {
	    	addRecipe();
	    } else if (choice.equals("VIEW")) {
	    	return;
	    } else if (choice.equals("DELETE")) {
	    	return;
	    }
	}
	
	public static void addRecipe() {
		Scanner key = new Scanner(System.in);
    	System.out.println("You've selected to add a recipe to the book. Let's begin!");
    	System.out.println("To begin, what is the name of the recipe?");
    	String name = key.nextLine();
    	System.out.println("Good. How long does this recipe take to make?");
    	String duration = key.nextLine();
    	System.out.println("Now quickly tell us how to how to make this. We'll get the ingredient list later.");
    	String instructions = key.nextLine();
    	Recipe recipe = new Recipe(name, duration, instructions);
    	boolean continuing = true;
    	System.out.println("Finally, we're gonna add some ingredients to the list.");
    	do {
    		System.out.println("Do you want to add an ingredient? Yes or no.");
    		String choice = key.nextLine();
    		if (choice.equals("Yes") || choice.equals("yes")) {
    			continuing = true;
    			System.out.println("What is the name of the ingredient you would like to the recipe?");
    			String ingredientName = key.nextLine();
    			System.out.println("And how much of this ingredient goes in the recipe?");
    			String ingredientMeasurement = key.nextLine();
    			recipe.addIngredient(ingredientName, ingredientMeasurement);
    		} else {
    			System.out.println("Okay, all ingredients have been added to the recipe then.");
    		}
    	} while (continuing == true);
    	System.out.println("This recipe is done! We're adding it to the recipe database.");
    	recipeList.add(recipe);
    	// ask here what the user would like to do next;
    	key.close();
    	for (int i = 0; i < recipeList.size(); i++) {
    		System.out.println("HERE'S A RECIPE: " + recipeList.get(i));
    	}
	}
	
	public static void main(String[] args) {
		start();
	}

}
