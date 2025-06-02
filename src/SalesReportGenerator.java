import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

class Sale {
    private final String region;
    private final String product;
    private final int quantity;
    private final double amount;

    public Sale(String region, String product, int quantity, double amount) {
        this.region = region;
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getRegion() {
        return region;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return region + " | " + product + " | Qty: " + quantity + " | Amount: $" + amount;
    }
}

public class SalesReportGenerator {

    public static void main(String[] args) {
        List<Sale> sales = readSalesFromFile();

        if (sales.isEmpty()) {
            System.out.println("No sales data found. Exiting.");
            return;
        }

        // 1. Unique regions (using Set)
        System.out.println("Unique Regions:");
        Set<String> uniqueRegions = sales.stream()
                .map(Sale::getRegion)
                .collect(Collectors.toSet());
        uniqueRegions.forEach(System.out::println);

        // 2. Unique products sold in each region (using Sorted Set)
        System.out.println("\nProducts sold per region:");
        Map<String, List<Sale>> eastRegionProducts = sales.stream()
                .collect(Collectors.groupingBy(Sale::getRegion));
        eastRegionProducts.forEach((region, groupedSales) -> {
            System.out.print(region + ": ");
            Set<String> productsPerRegion = groupedSales.stream()
                    .map(Sale::getProduct)
                    .collect(Collectors.toCollection(TreeSet::new));
            System.out.println(productsPerRegion);
        });

        // 3. Total sales amount per region
        System.out.println("\nTotal Sales Amount by Region:");
        Map<String, Double> salesByRegion = sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::getRegion,
                        Collectors.summingDouble(Sale::getAmount)
                ));
        salesByRegion.forEach((region, total) -> System.out.println(region + ": $" + total));
        // Total Quantity by region
        System.out.println("\nTotal Quantity by Region:");
        Map<String, Integer> quantitySalesByRegion = sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::getRegion,
                        Collectors.summingInt(Sale::getQuantity)
                ));
        quantitySalesByRegion.forEach((region, total) -> System.out.println(region + ": $" + total));
        // Average for region
        System.out.println("\nAverage by Region:");
        salesByRegion.forEach((region, total) -> System.out.printf("%s: $%.2f\n", region, total/ quantitySalesByRegion.get(region)));

        // 4. Top individual sale in North region (using Optional)
        System.out.println("\nTop Individual Sale in North Region:");
        Optional<Sale> topNorthSale = sales.stream()
                .filter(s -> s.getRegion().equalsIgnoreCase("North"))
                .max(Comparator.comparingDouble(Sale::getAmount));

        topNorthSale.ifPresentOrElse(
                sale -> System.out.println("Top Sale: " + sale),
                () -> System.out.println("No sales found in North region.")
        );

        // 5. Sales entries with amount below $200
        System.out.println("\nSales Entries with Amount < $200:");
        sales.stream()
                .filter(s -> s.getAmount() < 200)
                .forEach(System.out::println);

        // 6. Total quantity sold by product
        System.out.println("\nTotal Quantity Sold by Product:");
        Map<String, Integer> quantityByProduct = sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::getProduct,
                        Collectors.summingInt(Sale::getQuantity)
                ));
        quantityByProduct.forEach((product, qty) -> System.out.println(product + ": " + qty + " units"));

        // 7. Sales sorted by amount descending
        System.out.println("\nSales Sorted by Amount (Descending):");
        sales.stream()
                .sorted(Comparator.comparingDouble(Sale::getAmount).reversed())
                .forEach(System.out::println);
    }

    private static List<Sale> readSalesFromFile() {
        List<Sale> salesList = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get("C:/Users/keert/OneDrive - UNT System/Desktop/sales_data.txt"))) {
            lines.forEach(line -> {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    try {
                        String region = parts[0].trim();
                        String product = parts[1].trim();
                        int quantity = Integer.parseInt(parts[2].trim());
                        double amount = Double.parseDouble(parts[3].trim());
                        salesList.add(new Sale(region, product, quantity, amount));
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping malformed line: " + line);
                    }
                } else {
                    System.err.println("Skipping invalid line (wrong number of columns): " + line);
                }
            });
        } catch (IOException e) {
            System.err.println("Error reading sales data: " + e.getMessage());
        }
        return salesList;
    }
}
