package com.lonch.game.response;

import com.lonch.game.utils.ServiceResult;

/**
 * @description:
 * @author: lpx
 * @create: 2022-02-05 23:28
 */
public class CnResult<T> {
    private String timestamp;
    private String errorCode;
    private String errorMsg;
    private Boolean opFlag;
    private String protocolVersion;
    private String sid;
    private ServiceResult serviceResult;


    public static <T> CnResult<T> success() {
        CnResult cnResult = new CnResult();
        cnResult.opFlag=true;
        cnResult.setServiceResult(ServiceResult.ok());
        return cnResult;
    }

    public static <T> CnResult<T> success(T data) {
        CnResult cnResult = new CnResult();
        cnResult.opFlag=true;
        cnResult.setServiceResult(ServiceResult.ok(data));
        return cnResult;
    }

    public static <T> CnResult<T> fail() {
        CnResult cnResult = new CnResult();
        cnResult.opFlag=false;
        return cnResult;
    }

    public static <T> CnResult<T> fail(String message) {
        CnResult cnResult = new CnResult();
        cnResult.opFlag=false;
        cnResult.errorMsg=message;
        return cnResult;
    }


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Boolean getOpFlag() {
        return opFlag;
    }

    public void setOpFlag(Boolean opFlag) {
        this.opFlag = opFlag;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public ServiceResult getServiceResult() {
        return serviceResult;
    }

    public void setServiceResult(ServiceResult serviceResult) {
        this.serviceResult = serviceResult;
    }
}
