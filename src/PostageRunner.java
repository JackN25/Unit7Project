import java.util.Scanner;

public class PostageRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = "";
        while (!input.equals("4")) {
            System.out.println("---------------------------\n" +
                    "What would you like to do?\n" +
                    "1. Calculate cost of 1 package\n" +
                    "2. Simulate packages\n" +
                    "3. How package costs are calculated\n" +
                    "4. Exit");
            System.out.print("Input: ");
            input = s.nextLine();
            if (input.equals("1")) {
                System.out.print("\nEnter the zip code of the origin: ");
                int zip1 = Integer.parseInt(s.nextLine());
                System.out.print("Enter the zip code of the destination: ");
                int zip2 = Integer.parseInt(s.nextLine());
                System.out.print("Enter the weight of the package(pounds): ");
                double weight = Double.parseDouble(s.nextLine());
                System.out.print("Enter the height of the package(inches): ");
                double height = Double.parseDouble(s.nextLine());
                System.out.print("Enter the length of the package(inches): ");
                double length = Double.parseDouble(s.nextLine());
                System.out.print("Enter the width of the package(inches): ");
                double width = Double.parseDouble(s.nextLine());
                System.out.println("Cost: " + PostageCalculator.calculatePostage(zip1, zip2, weight, length, width, height));
            }
            else if (input.equals("2")) {
                System.out.print("\nHow many packages would you like to simulate: ");
                int amountToSimulate = Integer.parseInt(s.nextLine());
                PackageSimulator simulator = new PackageSimulator();
                simulator.generatePackages(amountToSimulate);
                System.out.println(simulator.getSimulationInfo());
            }
            else if (input.equals("3")) {
                System.out.println("\nPackages are calculated in 3 different ways:" +
                        "1. Distance between origin and destination\n" +
                        "2. Size of package\n" +
                        "3. Weight of package");
                System.out.println("The delivery comes with a base cost of $3.75.");
                System.out.println("The price for distance come from the difference in country codes(first 3 numbers in zip code) divided by 100.");
                System.out.println("The package gets charged extra if its dimensions combined exceeds 36 inches. It will be charged 10 cents per inch above 36.");
                System.out.println("The package gets charged 50 cents for each pound up to 40 pounds. Packages will be charged 1 dollar per pound over the 40 limit.\n");
            } else if (!input.equals("4")) {
                System.out.println("Please choose an available option(use numbers to choose).\n");
            }
        }
    }
}
