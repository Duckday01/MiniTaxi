package com.duclm.minitaxi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "trips")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_phone")
    private String customerPhone;

    private String description;

    @Column(name = "pickup_time")
    private LocalDateTime pickupTime;

    @Column(name = "price_bid")
    private BigDecimal priceBid;

    @Column(name = "money_customer_deposit")
    private BigDecimal moneyCustomerDeposit;

    @Column(name = "money_debt_agency")
    private BigDecimal moneyDebtAgency;

    @Column(name = "price_customer")
    private BigDecimal priceCustomer;

    private String status;

    @Column(name = "pickup_address")
    private String pickupAddress;

    @Column(name = "destination_address")
    private String destinationAddress;

    @Column(name = "round_trip")
    private Boolean roundTrip;

    private String area;
    private Boolean display;

    @Column(name = "type_of_car")
    private String typeOfCar;

    @Column(name = "is_have_bill")
    private Boolean isHaveBill;

    @Column(name = "is_collect_money")
    private Boolean isCollectMoney;

    @Column(name = "is_auto_price")
    private Boolean isAutoPrice;

    @Column(name = "no_auto_price")
    private Boolean noAutoPrice;

    @Column(name = "flag_driver")
    private Boolean flagDriver;

    @Column(name = "collected_money")
    private BigDecimal collectedMoney;

    @Column(name = "sell_start_time")
    private LocalDateTime sellStartTime;

    @Column(name = "source_trip")
    private String sourceTrip;

    @Column(name = "agency_id")
    private Long agencyId;

    @Column(name = "customer_property")
    private String customerProperty;

    @Column(name = "price_vat")
    private BigDecimal priceVat;

    private String service;

    @Column(name = "is_toll_fee")
    private Boolean isTollFee;

    private BigDecimal bonus;
    private String note;
}