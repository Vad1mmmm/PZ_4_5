package task_two;

import task_one.SupplyType;

public enum UAVType {
    COMBAT,
    RECON;

    private static final UAVType[] ENUM_VALUES = {
            COMBAT, RECON
    };

    public static UAVType[] myValues() {
        return ENUM_VALUES.clone();
    }
    public static UAVType myValueOf(String type){
        for (UAVType t : ENUM_VALUES) {
            if (t.name().equals(type)) {
                return t;
            }
        }
        throw new IllegalArgumentException("No such type " + type);
    }
}
