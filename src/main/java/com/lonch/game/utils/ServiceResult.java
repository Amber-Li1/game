package com.lonch.game.utils;

/**
 * @description:
 * @author: lpx
 * @create: 2022-03-16 10:54
 */
public class ServiceResult<T> {
    private String errorCode;
    private String reason;
    private Boolean success;
    private T data;

    public static <T> ServiceResult<T> ok(T data) {
        ServiceResult serviceResult=new ServiceResult();
        serviceResult.setSuccess(true);
        serviceResult.setData(data);
        return serviceResult;
    }

    public static <T> ServiceResult<T> ok() {
        ServiceResult serviceResult=new ServiceResult();
        serviceResult.setSuccess(true);
        return serviceResult;
    }

    public static <T> ServiceResult<T> fail() {
        ServiceResult serviceResult=new ServiceResult();
        serviceResult.setSuccess(false);
        return serviceResult;
    }

    public static <T> ServiceResult<T> fail(T data) {
        ServiceResult serviceResult=new ServiceResult();
        serviceResult.setSuccess(true);
        serviceResult.setData(data);
        return serviceResult;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
