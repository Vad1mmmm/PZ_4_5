package task_one;

public class Supply {
    private String name;
    private SupplyType type;
     private int quantity;
     private int storageDays;


     public Supply(String name, SupplyType type, int quantity, int storageDays) {
         this.name = name;
         this.type = type;
         this.quantity = quantity;
         this.storageDays = storageDays;
     }
     public String getName() {
         return name;
     }

     public int getQuantity() {
         return quantity;
     }

     public SupplyType getType() {
         return type;
     }

     public int getStorageDays() {
         return storageDays;
     }

     @Override
     public String toString() {
         return "task_one.Supply: name - " + name + ", type - " + type + ", quantity - " + quantity + ", storageDays - " + storageDays;
     }
}
