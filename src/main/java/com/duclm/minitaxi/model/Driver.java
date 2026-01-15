package com.duclm.minitaxi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "drivers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

    @Column(name = "display_name")
    private String displayName;

    private String password;

    @Column(name = "username")
    private String username; // Số điện thoại

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    private BigDecimal money;

    @Column(name = "driver_ban")
    private Boolean driverBan;

    private String bks;
    private Boolean enabled;

    @Column(name = "driver_rank")
    private String driverRank;

    private String role;

    @Column(name = "certificate_type")
    private String certificateType;

    @Column(name = "activity_area")
    private String activityArea;

    @Column(name = "referral_code")
    private String referralCode;

    private Double point;
    private String reason;
    private String english;
    private String avatar;
    private String status;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Driver parent; // Tài xế chính

    @Column(name = "is_sub_driver")
    private Boolean isSubDriver;

    @Column(name = "driver_license_front")
    private String driverLicenseFront;

    @Column(name = "driver_license_behind")
    private String driverLicenseBehind;

    @Column(name = "allow_notification")
    private Boolean allowNotification;

    @PrePersist
    protected void onCreate() {
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedOn = LocalDateTime.now();
    }
}