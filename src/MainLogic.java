import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainLogic {
    private List<Meal> chosenMeals = new ArrayList<>();
    private List<Meal> menu = new ArrayList<>();

    public double priceForMeals() {
        double sum = 0;
        for (Meal choosenMeal : chosenMeals) {
            sum += choosenMeal.getPrice();
        }
        return round(sum, 2);
    }

    public double tip() {
        if (priceForMeals() < 100) {
            return round((priceForMeals() * 0.15), 2);
        }
        return round((priceForMeals() * 0.1), 2);
    }

    public double finalPrice() {
        double sum = 0;
        for (Meal meal : chosenMeals) {
            sum += meal.getPrice();
        }
        return round((sum + tip()), 2);
    }

    public void printMenu() {
        menu.forEach(System.out::println);
    }

    public void printPayment() {
        System.out.println("Do zapłaty: " + finalPrice() + " w tym:");
        System.out.println("Koszty dań: " + priceForMeals());
        System.out.println("Napiwek: " + tip());

    }

    public void changeStringToIntegers(String numbers) {
        List<String> items = Arrays.asList(numbers.split("\\s*,\\s*"));
        items.forEach(x -> {
            addToBill(Integer.parseInt(x));
        });

    }

    public void addToBill(int mealNumber) {
        menu.forEach(meal -> {
            if (meal.getNumber() == mealNumber) {
                chosenMeals.add(meal);
            }
        });
    }

    public void addToMenu(Meal meal) {
        menu.add(meal);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}

