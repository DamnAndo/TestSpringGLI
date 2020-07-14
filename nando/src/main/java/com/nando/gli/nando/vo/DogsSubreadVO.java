package com.nando.gli.nando.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DogsSubreadVO {

    private List<String> message;
    private String status;

    public DogsSubreadVO() {
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
