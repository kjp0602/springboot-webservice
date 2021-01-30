package com.tera.project.springboot.web.dto;

import com.tera.project.springboot.domain.consult.Consult;
import com.tera.project.springboot.domain.consult.ConsultSaveHistory;
import com.tera.project.springboot.domain.consult.ConsultStatus;
import com.tera.project.springboot.domain.user.User;
import lombok.Builder;

public class ConsultSaveHistoryDto {
    private User user;
    private ConsultStatus consultStatus;
    private Consult consult;

    @Builder
    public ConsultSaveHistoryDto(User user, ConsultStatus consultStatus, Consult consult) {
        this.user = user;
        this.consultStatus = consultStatus;
        this.consult = consult;
    }

    public ConsultSaveHistory toEntity() {
        return ConsultSaveHistory.builder().user(user).consult(consult).consultStatus(consultStatus).build();
    }
}
