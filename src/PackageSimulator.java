import java.util.ArrayList;
import java.text.DecimalFormat;
import java.math.RoundingMode;
public class PackageSimulator {
    ArrayList<Package> packages = new ArrayList<Package>();

    public void generatePackages(int amount) {
        for (int i = 0; i < amount; i++) {
            packages.add(new Package(Address.randomAddress(), Address.randomAddress(), (int) (Math.random() * 51.1) + 0.1,  (Math.random() * 19) + 2,  (Math.random() * 19) + 2,  (Math.random() * 19) + 2));
        }
    }

    public String generateTotalCost() {
        DecimalFormat df = new DecimalFormat("#.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        double totalCost = 0;
        for (Package p : packages) {
            totalCost += Double.parseDouble(PostageCalculator.calculatePostage(p));
        }
        return df.format(totalCost);
    }

    public String getSimulationInfo() {
        String s = "Randomly generated packages info:\n";
        int packageNum = 0;
        for (Package p : packages) {
            packageNum++;
            s += "\nPackage " + packageNum + ": ___________________________________________\n" +
                    "Origin address: " + p.getOrigin() + "\n" +
                    "Destination address: " + p.getDestination() + "\n" +
                    "Weight: " + p.getPounds() + " pounds\n" +
                    "Height: " + p.getHeight() + " inches\n" +
                    "Length: " + p.getLength() + " inches\n" +
                    "Width: " + p.getWidth() + " inches\n" +
                    "Cost: " + PostageCalculator.calculatePostage(p) + "\n";
        }
        s += "\nTOTAL COST: " + generateTotalCost();
        return s;
    }

    public static String getCalculationInfo() {
        String info =
                "\nPackages are calculated in 3 different ways:" +
                "1. Distance between origin and destination\n" +
                "2. Size of package\n" +
                "3. Weight of package\n" +
                "The delivery comes with a base cost of $3.75.\n" +
                "The price for distance come from the difference in country codes(first 3 numbers in zip code) divided by 100.\n" +
                "The package gets charged extra if its dimensions combined exceeds 36 inches. It will be charged 10 cents per inch above 36.\n" +
                "The package gets charged 50 cents for each pound up to 40 pounds. Packages will be charged 1 dollar per pound over the 40 limit.\n";
        return info;
    }

    public void resetSimulation() {
        packages.clear();
    }
}
