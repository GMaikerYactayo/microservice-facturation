package com.bill.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {

    private int client_id;
    private String name;
    private String lastname;
    private String email;

}
