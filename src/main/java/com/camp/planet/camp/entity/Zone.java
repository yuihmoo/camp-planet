package com.camp.planet.camp.entity;

import com.camp.planet.camp.constant.ZoneType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Entity
@Table(name = "zone")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Zone {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID siteId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String profile;

    @Column(nullable = false)
    private String introduce;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private LocalDateTime checkIn;

    @Column(nullable = false)
    private LocalDateTime checkOut;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private ZoneType type;

    @Column(nullable = false)
    private String floorMaterial;

    @Column(nullable = false)
    private int recommendPeople;

    @Column(nullable = false)
    private boolean isParking;

    @Column(nullable = false)
    private int minReservationDay;

    @Column(nullable = false)
    private Double width;

    @Column(nullable = false)
    private Double height;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;
}
