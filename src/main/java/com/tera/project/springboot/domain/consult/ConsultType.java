package com.tera.project.springboot.domain.consult;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ConsultType {
    SOFTWARE("TYPE_SOFTWARE", "소프트웨어"),
    HARDWARE("TYPE_HARDWARE", "하드웨어"),
    OPERATION("TYPE_OPERATION", "경영");

    private final String  key;
    private final String title;
}
