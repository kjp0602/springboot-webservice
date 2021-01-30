package com.tera.project.springboot.domain.consult;

import com.tera.project.springboot.domain.BaseTimeEntity;
import com.tera.project.springboot.domain.store.Store;
import com.tera.project.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ConsultSaveHistory extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private User user;

    private void setUser(User user) {
        if(this.user != null) {
            this.user.getConsultSaveHistoryList().remove(this);
        }
        this.user = user;
        user.getConsultSaveHistoryList().add(this);
    }

    @ManyToOne
    private Consult consult;

    private void setConsult(Consult consult) {
        if(this.consult != null) {
            this.consult.getConsultSaveHistoryList().remove(this);
        }
        this.consult = consult;
        consult.getConsultSaveHistoryList().add(this);
        consult.setConsultStatus(this.consultStatus);
    }
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConsultStatus consultStatus;

    @Builder
    public ConsultSaveHistory(User user, Consult consult, ConsultStatus consultStatus) {
        setUser(user);
        setConsult(consult);
        this.consultStatus = consultStatus;
    }
}
