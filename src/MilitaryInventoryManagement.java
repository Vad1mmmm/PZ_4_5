import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MilitaryInventoryManagement {

    private List<Supply> supplies = new ArrayList<>();

    public int totalQuantityOfWeaponrySupplies() {
        return supplies.stream()
                .filter(s -> s.getType() == SupplyType.AMMUNITION)
                .mapToInt(Supply::getQuantity)
                .sum();
    }
    public void displaySupplies() {
        supplies.forEach(System.out::println);
    }
    public void addSupply(Supply supply) {
        supplies.add(supply);
    }
    public Optional<Supply> findLongestStoredNonPerishableItem(){
        return supplies.stream()
                .max((s1, s2) -> Integer.compare(s1.getStorageDays(), s2.getStorageDays()));

    }
    public void filterPerishableItemsWithLowQuantity(int lowQuantity) {
        supplies.stream()
                .filter(supply -> supply.getQuantity() <= lowQuantity && supply.getStorageDays() <= 10)
                .forEach(System.out::println);
    }
}

