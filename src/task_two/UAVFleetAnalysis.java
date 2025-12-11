package task_two;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static javax.swing.UIManager.put;

public class UAVFleetAnalysis {
    private List<UAV> uavsMain = new ArrayList<>();

    //1//
    public static List<String> listIDsOperationalCombatUAVs(List<UAV> uavs){
        return uavs.stream()
                .filter(UAV::isOperational)
                .filter(u -> u.getType().equals(UAVType.COMBAT))
                .map(UAV::getId)
                .toList();
    }

    //2//
    public static void displayUAVWithMostMissions(List<UAV> uavs) {
        uavs.stream()
                .max((u1, u2) -> Integer.compare(u1.getMissionsCompleted(), u2.getMissionsCompleted()))
                .ifPresentOrElse(
                        uav -> System.out.println("БПЛА з найбільшою кількістю місій: " + uav.getType()
                                + ", ID: " + uav.getId()
                                + ", кількість місій: " + uav.getMissionsCompleted()),
                                () -> System.out.println("Нічого не знайдено.")
                        );
    }
    //3//
    public static int totalFlightHoursForReconUAVs (List<UAV> uavs){
        return uavs.stream()
                .filter(u -> u.getType().equals(UAVType.RECON))
                .mapToInt(UAV::getHoursFlown)
                .sum();
    }
    //4//
    public static double averageMissionsOfOperationalUAVs(List<UAV> uavs){
        return uavs.stream()
                .filter(u -> u.isOperational())
                .mapToInt(UAV::getMissionsCompleted)
                .average()
                .orElse(0.0);
    }
    //5//
    public static Map<UAVType, List<UAV>> groupUAVsByType(List<UAV> uavs){
        Map<UAVType, List<UAV>> map = uavs.stream()
                .collect(Collectors.groupingBy(UAV::getType));

        map.forEach((type, list) -> {
            System.out.println("Тип: " + type);
            list.forEach(u -> System.out.println(" " + u));
            System.out.println();
        });
        return map;
    }
    //6//
    public static Map<UAVType, List<UAV>> summaryOfNonOperationalUAVsByType(List<UAV> uavs){
        Map<UAVType, List<UAV>> map = uavs.stream()
                .filter(u -> !u.isOperational())
                .collect(Collectors.groupingBy(
                        UAV::getType));

        Map<UAVType, Integer> hours = uavs.stream()
                .filter(u -> !u.isOperational())
                .collect(Collectors.groupingBy(UAV::getType,
                        Collectors.summingInt(UAV::getHoursFlown)));

        map.forEach((type, list) -> {
            System.out.println("Тип: " + type);
            System.out.println("Загальна кількість годин: " + hours.getOrDefault(type, 0));
            list.forEach(u -> System.out.println(" " + u));
            System.out.println();
        });

        return map;
    }


}
