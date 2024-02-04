package com.camp.planet.camp.constant;

import lombok.Getter;

@Getter
public enum SiteType {
    AUTO(0),
    GLAMPING(1),
    CARAVAN(2),
    HOUSE(3);

    private final int value;

    SiteType(int value) {
        this.value = value;
    }

}
