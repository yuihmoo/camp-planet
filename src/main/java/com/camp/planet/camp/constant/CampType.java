package com.camp.planet.camp.constant;

public enum CampType {
    AUTO(0),
    GLAMPING(1),
    CARAVAN(2),
    HOUSE(3);

    private final int value;

    CampType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
