package com.camp.planet.camp.entity;

import com.camp.planet.camp.constant.CampType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Entity
@Table(name = "site")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Site {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    @Column
    private String accountId;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private CampType type;

    @Column
    private String environment;

    @Column
    private String introduce;

    @Column
    private String roleType;

    @Column
    private String profile;

    @Column
    private String layout;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;
}
