package com.camp.planet.camp.constant;

import lombok.Getter;

@Getter
public enum ZoneType {
    CRUSHED_STONE(0),
    DECK(1),
    GRASS(2),
    GRAVEL(3);

    private final int value;

    ZoneType(int value) {
        this.value = value;
    }

}
