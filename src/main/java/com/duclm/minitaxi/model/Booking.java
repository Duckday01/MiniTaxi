package com.duclm.minitaxi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "agency_id")
    private Long agencyId;

    @Column(name = "pickup_address")
    private String pickupAddress;

    @Column(name = "destination_address")
    private String destinationAddress;

    @Column(name = "round_trip")
    private Boolean roundTrip;

    @Column(name = "is_have_bill")
    private Boolean isHaveBill;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "pickup_time")
    private LocalDateTime pickupTime;

    @Column(name = "type_of_car")
    private String typeOfCar;

    private String note;
    private String status;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

    @Column(name = "type_reject")
    private String typeReject;

    private String type; // Nguồn nhận lịch

    @Column(name = "price_customer")
    private BigDecimal priceCustomer;

    @Column(name = "price_bid")
    private BigDecimal priceBid;

    @Column(name = "is_collect_money")
    private Boolean isCollectMoney;

    private String area;

    @Column(name = "customer_property")
    private String customerProperty;

    private String service;

    @Column(name = "is_toll_fee")
    private Boolean isTollFee;

    private BigDecimal bonus;
}