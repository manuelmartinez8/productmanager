package com.web.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ErrorResponse {

    public String bad_request;
    public List<String> details;

    public ErrorResponse(String bad_request, List<String> details) {
        this.bad_request = bad_request;
        this.details = details;
    }


}
