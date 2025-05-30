import java.util.*;
import java.util.stream.Collectors;

class Sale {
    String region;
    double amount;

    public Sale(String region, double amount) {
        this.region = region;
        this.amount = amount;
    }

    public String getRegion() {
        return region;
    }

    public double getAmount() {
        return amount;
    }
}

public class SalesReportGenerator {
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale("North", 200.0),
                new Sale("South", 150.0),
                new Sale("East", 300.0),
                new Sale("West", 400.0),
                new Sale("North", 150.0),
                new Sale("East", 250.0)
        );

        // Grouping by region and filtering out sales below a threshold
        double threshold = 100.0;

        Map<String, List<Sale>> groupedSales = sales.stream()
                .filter(sale -> sale.getAmount() >= threshold) // Filter sales
                .collect(Collectors.groupingBy(Sale::getRegion)); // Group by region

        System.out.println("Sales Report:");
        System.out.println("Region\tTotal Sales\tAverage Sales");

        // Calculating total and average using map and reduce
        for (Map.Entry<String, List<Sale>> entry : groupedSales.entrySet()) {
            String region = entry.getKey();
            List<Sale> salesList = entry.getValue();

            double total = salesList.stream()
                    .map(Sale::getAmount) // Map to amounts
                    .reduce(0.0, Double::sum); // Reduce to total

            double average = salesList.stream()
                    .map(Sale::getAmount)
                    .reduce(0.0, Double::sum) / salesList.size(); // Calculate average

            System.out.printf("%s\t%.2f\t\t%.2f%n", region, total, average);
        }
    }
}