package com.bill.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayMode implements Serializable {

    private int pay_mode_id;
    private String name;
    private String other_detail;

}
