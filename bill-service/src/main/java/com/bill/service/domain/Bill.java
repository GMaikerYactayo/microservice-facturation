package com.bill.service.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bill_id;
    private LocalDate date_creation;
    @Column(name = "total")
    private float total;
    private int client_id;
    private int pay_mode_id;
    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<Detail> detail = new ArrayList<>();

}
