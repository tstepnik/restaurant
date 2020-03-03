import java.util.Scanner;

public class Restaurant {
    MainLogic mainLogic = new MainLogic();

    public void makeOrderGetBill() {
        Scanner sc = new Scanner(System.in);
        boolean exception = true;
            mainLogic.addToMenu(new Meal(1, "Pizza Margerita", 23.40));
            mainLogic.addToMenu(new Meal(2, "Pizza Mafioso", 29.99));
            mainLogic.addToMenu(new Meal(3, "Spaghetti Bolognese", 31.99));
            mainLogic.addToMenu(new Meal(4, "SPaghetti Carbonara", 26.99));
            mainLogic.addToMenu(new Meal(5, "Lasagne", 24.99));
        while (exception) {
            mainLogic.printMenu();
            System.out.println("Zamów wybrane potrawy podając ich numery po przecinku:");
            try {
                mainLogic.changeStringToIntegers(sc.nextLine());
                exception = false;
            } catch (NumberFormatException i) {
                System.err.println("Możesz podawać tylko liczby całkowite oddzielając je przecinkiem.");
            }
        }
        mainLogic.printPayment();
        sc.close();
    }
}
