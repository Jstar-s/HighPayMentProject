package com.jstar.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/8/20 14:43
 */


@Entity
@Table(name = "tb_customer")
@Data
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;


    @Column(name = "cust_name")
    private String custName;

    @Column(name = "cust_address")
    private String custAddress;



}
