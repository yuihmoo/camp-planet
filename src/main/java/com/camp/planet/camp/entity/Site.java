package com.camp.planet.camp.entity;

import com.camp.planet.camp.constant.SiteType;
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

    @Column(nullable = false)
    private String accountId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private SiteType type;

    @Column(nullable = false)
    private String environment;

    @Column(nullable = false)
    private String introduce;

    @Column(nullable = false)
    private String roleType;

    @Column(nullable = false)
    private String profile;

    @Column(nullable = false)
    private String layout;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;
}
