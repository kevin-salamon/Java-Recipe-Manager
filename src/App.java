import java.util.ArrayList;
import java.util.Scanner;

public class App {

	protected ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
	protected Scanner key = new Scanner(System.in);
	
	public void end() {
		System.out.println("You've chosen to end the program. Goodbye!");
		key.close();
	}

	public void start() {
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
	    
	    if (choice.equals("ADD")) {
	    	addRecipe();
	    } else if (choice.equals("VIEW")) {
	    	if (recipeList.size() > 0) {
	    		viewRecipe();
	    	} else {
	    		System.out.println("Sorry, there are no recipes to view.");
	    		start();
	    	}
	    } else if (choice.equals("DELETE")) {
	    	if (recipeList.size() > 0) {
		    	removeRecipe();
	    		return;
	    	} else {
	    		System.out.println("Sorry, there are no recipes to delete.");
	    		start();
	    	}
	    }
	}
	
	public void addRecipe() {
    	System.out.println("You've selected to add a recipe to the book. To begin, what is the name of the recipe?");
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
    			continuing = false;
    		}
    	} while (continuing == true);
    	System.out.println("This recipe is done! We're adding it to the recipe database.");
    	recipeList.add(recipe);
		System.out.println("Would you like to add another recipe?");
    	String recipeChoice = key.nextLine();
		if (recipeChoice.equals("Yes") || recipeChoice.equals("yes")) {
			addRecipe();
		} else {
			System.out.println("Okay - would you like to continue?");
			String continueChoice = key.nextLine();
			if (continueChoice.equals("Yes") || continueChoice.equals("yes")) {
				start();
			} else {
				end();
			}
		}
	}
	
	public void viewRecipe() {
    	System.out.println("You've selected to view recipes. Would you like to view a specific recipe or see a list?");
    	String choice;
	    boolean correct = false;

	    do {
		    System.out.println("Choose ONE or ALL.");
	    	choice = key.nextLine();
	    	if (choice.equals("ONE") || choice.equals("ALL") || choice.equals("one") || choice.equals("all")) {
	    		correct = true;
	    	} else {
	    		System.out.println("Incorrect choice.");
	    	}
	    } while (correct == false);
	    
    	if (choice.equals("ONE") || choice.equals("one")) {
    		viewOne();
    	} else if (choice.equals("all") || choice.equals("ALL")) {
    		System.out.println("Okay, here are the names of all the recipes you've saved: ");
    		for (int i = 0; i < recipeList.size(); i++) {
    			System.out.println("RECIPE " + (i + 1) + ": " + recipeList.get(i).name);
    		}
    		System.out.println("Would you like to continue?");
    		String continueChoice = key.nextLine();
    		if (continueChoice.equals("Yes") || continueChoice.equals("yes")) {
    			start();
    		} else {
    			end();
    		}
    	}
	}
	
	public void viewOne() {
		System.out.println("Okay, what is the name of the recipe you would like to look up?");
		boolean contains = false;
		String recipeName;
		do {
    		recipeName = key.nextLine();
    		for (int i = 0; i < recipeList.size(); i++) {
    			if (recipeList.get(i).name.equals(recipeName)) {
    				contains = true;
    			}
    		}
    		if (contains = false) {
    			System.out.println("Sorry - there's no recipe by that name. Please try again");
    		}
		} while (contains = false);
		
		System.out.println("Okay, we found that recipe. Here's the layout.");
		for (Recipe recipe : recipeList) {
			if (recipe.name.equals(recipeName)) {
    			System.out.println("RECIPE NAME: " + recipe.name);
    			System.out.println("RECIPE TOTAL TIME: " + recipe.duration);
    			System.out.println("RECIPE INSTRUCTIONS: " + recipe.instructions);
    			for (int i = 0; i < recipe.ingredientList.size(); i++) {
    				System.out.println("INGREDIENT " + (i + 1) + ": " + recipe.ingredientList.get(i).name);
    				System.out.println("COUNT: " + recipe.ingredientList.get(i).measurement);
    			}
			} else {
				continue;
			}
		}
		System.out.println("Would you like to view another recipe?");
		String viewChoice = key.nextLine();
		if (viewChoice.equals("YES") || viewChoice.equals("Yes") || viewChoice.equals("yes")) {
			viewOne();
		} else {
    		System.out.println("Would you like to continue?");
    		String continueChoice = key.nextLine();
    		if (continueChoice.equals("Yes") || continueChoice.equals("yes")) {
    			start();
    		} else {
    			end();
    		}
		}
	}
	
	public void removeRecipe() {
		System.out.println("What is the name of the recipe you would like to delete?");
		boolean contains = false;
		String recipeName;
		do {
    		recipeName = key.nextLine();
    		for (int i = 0; i < recipeList.size(); i++) {
    			if (recipeList.get(i).name.equals(recipeName)) {
    				recipeList.remove(i);
    				contains = true;
    			}
    		}
    		if (contains = false) {
    			System.out.println("Sorry - there's no recipe by that name. Please try again");
    		}
		} while (contains = false);
		System.out.println("Okay, we've found that recipe and deleted it for you.");
		System.out.println("Would you like to continue?");
		String continueChoice = key.nextLine();
		if (continueChoice.equals("Yes") || continueChoice.equals("yes")) {
			start();
		} else {
			end();
		}
	}
	
	public static void main(String[] args) {
		App app = new App();
	    System.out.println("-----------------------");
	    System.out.println("Welcome to the Recipe Book! To begin, choose whether you would like to view, add, or delete recipes.");
		app.start();
	}

}
