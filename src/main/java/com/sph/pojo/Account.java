package com.sph.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account
{
    private Integer id;
    private Integer balance;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private Integer gender; // 1 == male || 0 == female

}
