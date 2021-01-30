package com.tera.project.springboot.web.dto;

import com.tera.project.springboot.domain.consult.ConsultStatus;
import com.tera.project.springboot.domain.consult.ConsultType;
import com.tera.project.springboot.domain.user.User;

public class ConsultUpdateRequestDto {
    private String reception;
    private String proceeding;
    private ConsultType consultType;
    private ConsultStatus consultStatus;
}
