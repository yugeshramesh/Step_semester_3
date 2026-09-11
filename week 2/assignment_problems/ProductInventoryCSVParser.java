/**
 * Assignment Problem 3: Product Inventory CSV Parser
 * Scenario: Warehouse Inventory Updates
 * 
 * Task:
 * - Split CSV line "ProductName,SKU,Quantity" by comma.
 * - Validate exactly 3 fields; print "Invalid Record" if invalid.
 * - Print formatted: "Product: ... | SKU: ... | Qty: ...".
 */
public class ProductInventoryCSVParser {

    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
    }

    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        // Output: Product: Wireless Mouse | SKU: WM-2201 | Qty: 150

        parseInventoryRecord("Wireless Mouse,150");
        // Output: Invalid Record
    }
}
