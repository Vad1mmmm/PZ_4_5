public enum SupplyType {
    AMMUNITION,
    FOOD,
    MEDICAL,
    FUEL,
    EQUIPMENT;

    private static final SupplyType[] ENUM_VALUES = {
            AMMUNITION, FOOD, MEDICAL, FUEL, EQUIPMENT
    };

    public static SupplyType[] myValues() {
        return ENUM_VALUES.clone();
    }
    public static SupplyType myValueOf(String type){
        for (SupplyType t : ENUM_VALUES) {
            if (t.name().equals(type)) {
                return t;
            }
        }
        throw new IllegalArgumentException("No such type " + type);
    }
}

