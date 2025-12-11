package task_two;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static javax.swing.UIManager.put;

public class UAVFleetAnalysis {
    private List<UAV> uavsMain = new ArrayList<>();

    //1//
    public static List<String> summaryOfNonOperationalUAVsByType (List<UAV> uavs) {
        return uavs.stream()
                .filter(UAV::isOperational)
                .filter(u -> u.getType() == UAVType.COMBAT)
                .map(UAV::getId)
                .collect(Collectors.toList());
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
        return uavs.stream()
                .
    }
}
