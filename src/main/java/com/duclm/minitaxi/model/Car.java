package com.duclm.minitaxi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

    private String bks; // Biển kiểm soát
    private String color;
    private String type; // Hãng xe

    @Column(name = "type_of_car")
    private String typeOfCar; // Loại xe

    @Column(name = "registration_certificate_front")
    private String registrationCertificateFront;

    @Column(name = "registration_certificate_behind")
    private String registrationCertificateBehind;

    @Column(name = "album_registration_certificate")
    private String albumRegistrationCertificate;

    @Column(name = "album_insurance")
    private String albumInsurance;

    private String note;

    @Column(name = "car_year")
    private Integer carYear;

    @Column(name = "car_type")
    private String carType; // Xăng hoặc điện

    @Column(name = "license_type")
    private String licenseType; // Màu biển số

    @PrePersist
    protected void onCreate() {
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedOn = LocalDateTime.now();
    }
}