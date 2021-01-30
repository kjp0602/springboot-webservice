package com.tera.project.springboot.domain.store;

import com.tera.project.springboot.domain.BaseTimeEntity;
import com.tera.project.springboot.domain.consult.Consult;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Store extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 4, nullable = false)
    private String storeCode;

    @Column(length = 50, nullable = false)
    private String storeName;

    @Column(length = 100)
    private String address;

    @Column(length = 20)
    private String phoneNumber;

    @OneToMany(mappedBy = "store")
    private List<Consult> consultList = new ArrayList<>();
}
