package com.tera.project.springboot.domain.consult;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ConsultStatus {
    ACCEPTING("STATUS_ACCEPTING", "접수"),
    TRANSLATED("STATUS_TRANSLATED", "처리중"),
    QUESTION("STATUS_QUESTION", "확인요청"),
    COMPLETED("STATUS_COMPLETED", "처리완료"),
    FEEDBACK("STATUS_FEEDBACK", "안내완료");

    private final String  key;
    private final String title;
}
