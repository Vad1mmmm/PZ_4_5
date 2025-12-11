package task_one;

import java.util.List;

class Main {
     public static void main(String[] args) {

         List<Supply> supplies = List.of(
                 new Supply("food", SupplyType.FOOD, 50, 9),
                new Supply("ammunition-7,62", SupplyType.AMMUNITION, 9, 5),
                new Supply("fuel", SupplyType.FUEL, 10, 15),
                new Supply("equipment", SupplyType.EQUIPMENT, 6, 2),
                new Supply("ammunition-5,56", SupplyType.AMMUNITION, 550, 5),
                new Supply("food", SupplyType.FOOD, 50, 15),
                new Supply("fuel-diesel", SupplyType.FUEL, 50, 15),
                 new Supply("medical1", SupplyType.MEDICAL, 45, 20),
                 new Supply("medical2", SupplyType.MEDICAL, 45, 10),
                 new Supply("medical3", SupplyType.MEDICAL, 45, 17),
                 new Supply("medical4", SupplyType.MEDICAL, 45, 17)
         );

         MilitaryInventoryManagement inventory = new MilitaryInventoryManagement();
         for (int i = 0; i < supplies.size(); i++) {
             Supply supply = supplies.get(i);
             inventory.addSupply(supply);
         }

         inventory.addSupply(new Supply("HELP ME", SupplyType.FOOD, 60, 100));

         inventory.displaySupplies();

         System.out.println("\nТовар з найдовшим терімном придатності: ");
         System.out.println(inventory.findLongestStoredNonPerishableItem());
         System.out.println("\nШвидкопсувні товари з невеликою кількістю: ");
         inventory.filterPerishableItemsWithLowQuantity(10);
         System.out.println("\nОтримати всі товари даного типу: ");
         inventory.getSuppliesByType(SupplyType.FOOD);
         System.out.println("\nОтримати середній термін придатності медичниго забезпечення: ");
         System.out.println(inventory.averageStorageDaysForMedicalSupplies());
         System.out.println("Групування забезпечення з малим терміном придатності за типом: ");
         inventory.summaryOfPerishableSuppliesByType();
         System.out.println("Групування забезпечення за типом: ");
         inventory.groupSuppliesByType();
         System.out.println("totalQuantityOfWeaponrySupplies: ");
         System.out.println(inventory.totalQuantityOfWeaponrySupplies());

     }
}