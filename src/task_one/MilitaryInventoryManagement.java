package task_one;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MilitaryInventoryManagement {

    private List<Supply> supplies = new ArrayList<>();


    //3//
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

    //2//
    //Я не бачив сенсу додавати тут filter
    public Optional<Supply> findLongestStoredNonPerishableItem(){
        return supplies.stream()
                .max((s1, s2) -> Integer.compare(s1.getStorageDays(), s2.getStorageDays()));

    }

    //1//
    public void filterPerishableItemsWithLowQuantity(int lowStorgeDays) {
        supplies.stream()
                .filter(supply -> supply.getQuantity() <= 50 && supply.getStorageDays() <= lowStorgeDays)
                .map(Supply::getName)
                .forEach(System.out::println);
    }
    public void getSuppliesByType(SupplyType type){
        supplies.stream()
                .filter(supply -> supply.getType() == type)
                .forEach(System.out::println);
    }

    //4//
    public Optional<Double> averageStorageDaysForMedicalSupplies() {
        return supplies.stream()
                .filter(s -> s.getType() == SupplyType.MEDICAL)
                .mapToDouble(Supply::getStorageDays)
                .average()
                .stream()
                .boxed()
                .findFirst();

    }

    //6//
    public void summaryOfPerishableSuppliesByType() {

        Map<SupplyType, List<Supply>> map = supplies.stream()
                .filter(s -> s.getStorageDays() < 10)
                .collect(Collectors.groupingBy(
                        Supply::getType
                ));
        Map<SupplyType, Integer> sums = supplies.stream()
                .filter(s -> s.getStorageDays() < 10)
                .collect(Collectors.groupingBy(
                        Supply::getType,
                        Collectors.summingInt(Supply::getQuantity)));


        map.forEach((type, list) -> {
            System.out.println("Тип " + type);
            list.forEach(s -> System.out.println(" " + s));
            System.out.println("Кількість забезпечення: " + sums.get(type));
            System.out.println();
        });
    }

    //5//
    public void groupSuppliesByType(){
        Map<SupplyType, List<Supply>> map = supplies.stream()
                .collect((Collectors.groupingBy(Supply::getType)));
        map.forEach((type, list) -> {
            System.out.println("Тип " + type);
            list.forEach(s -> System.out.println(" " + s));
            System.out.println();
        });
    }
}

