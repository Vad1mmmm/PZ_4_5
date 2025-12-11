package task_two;

import java.util.List;

public class Main {
    public static void main (String[] args){
        List<UAV> uavs = List.of(
                new UAV("1", UAVType.COMBAT, 17, 12, true),
                new UAV("2", UAVType.RECON, 16, 7, true),
                new UAV("3", UAVType.COMBAT, 87, 50, false),
                new UAV("4", UAVType.COMBAT, 14, 10, true),
                new UAV("5", UAVType.RECON, 11, 2, false),
                new UAV("6", UAVType.COMBAT, 37, 24, true),
                new UAV("7", UAVType.RECON, 1, 10, false),
                new UAV("8", UAVType.COMBAT, 7, 27, false)
        );

        System.out.println("Робочі бойові дрони: ");
        System.out.println(UAVFleetAnalysis.summaryOfNonOperationalUAVsByType(uavs));
        System.out.println("Дрон з найбільшою кількістю місій: ");
        UAVFleetAnalysis.displayUAVWithMostMissions(uavs);
        System.out.println("Загальні години польоту для розвідувальних БПЛА: ");
        System.out.println(UAVFleetAnalysis.totalFlightHoursForReconUAVs(uavs));
        System.out.println("Середня кількість місій для працездатних БПЛА: ");
        System.out.println(UAVFleetAnalysis.averageMissionsOfOperationalUAVs(uavs));
        }


    }

