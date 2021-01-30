package com.tera.project.springboot.web.dto;

import com.tera.project.springboot.domain.consult.Consult;
import com.tera.project.springboot.domain.consult.ConsultSaveHistory;
import com.tera.project.springboot.domain.consult.ConsultStatus;
import com.tera.project.springboot.domain.consult.ConsultType;
import com.tera.project.springboot.domain.posts.Posts;
import com.tera.project.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ConsultSaveRequestDto {

    private User user;
    private String reception;
    private String proceeding;
    private ConsultType consultType;
    private ConsultStatus consultStatus;

    @Builder
    public ConsultSaveRequestDto(User user, String reception, String proceeding, ConsultType consultType, ConsultStatus consultStatus) {
        this.reception = reception;
        this.proceeding = proceeding;
        this.user = user;
        this.consultType = consultType;
        this.consultStatus = consultStatus;

    }

    public Consult toEntity() {
        return Consult.builder().reception(reception).proceeding(proceeding).consultType(consultType).consultStatus(consultStatus).build();
    }


}
