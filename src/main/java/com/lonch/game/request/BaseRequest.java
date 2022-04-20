package com.lonch.game.request;

import java.io.Serializable;

/**
 * @description:
 * @author: lpx
 * @create: 2022-03-16 16:51
 */
public class BaseRequest implements Serializable {

    public String ip;
    public String sid;
    public Long timestamp;


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
