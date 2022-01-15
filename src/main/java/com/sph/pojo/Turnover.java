package com.sph.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Turnover
{
    private Integer id;
    private String fk;
    private String type;
    private Integer amount;
    private Date date;
}
