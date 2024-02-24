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
                System.out.println(PackageSimulator.getCalculationInfo());
            } else if (!input.equals("4")) {
                System.out.println("Please choose an available option(use numbers to choose).\n");
            }
        }
    }
}
