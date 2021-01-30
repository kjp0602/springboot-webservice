package com.tera.project.springboot.domain.consult;

import com.tera.project.springboot.domain.BaseTimeEntity;
import com.tera.project.springboot.domain.store.Store;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Consult extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String reception;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String proceeding;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConsultType consultType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConsultStatus consultStatus;

    @ManyToOne
    private Store store;

    @OneToMany(mappedBy = "consult", fetch = FetchType.LAZY)
    private List<ConsultSaveHistory> consultSaveHistoryList = new ArrayList<>();



    @Builder
    public Consult(String reception, String proceeding, ConsultType consultType, ConsultStatus consultStatus, Store store) {
        this.reception = reception;
        this.proceeding = proceeding;
        this.consultType = consultType;
        this.consultStatus = consultStatus;
        setStore(store);
    }

    private void setStore(Store store) {
        if(this.store != null) {
            this.store.getConsultList().remove(this);
        }
        this.store = store;
        store.getConsultList().add(this);
    }

    protected void setConsultStatus(ConsultStatus consultStatus){
        this.consultStatus = consultStatus;
    }

    public void update(String reception, String proceeding, ConsultStatus consultStatus, ConsultType consultType){
        this.reception = reception;
        this.proceeding = proceeding;
        this.consultStatus = consultStatus;
        this.consultType = consultType;
    }


}
