package com.greenowl.tracker.web.rest.dto;

/**
 * Created by Ahmed on 2015-06-05.
 */
public class PushMessageDTO {

    private String msg;

    private String token;

    public PushMessageDTO() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "PushMessageDTO{" +
                "msg='" + msg + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
