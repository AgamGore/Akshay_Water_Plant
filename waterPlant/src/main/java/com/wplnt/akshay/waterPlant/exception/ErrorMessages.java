package com.wplnt.akshay.waterPlant.exception;

public enum ErrorMessages {

    IN("Invalid input, only numbers are allowed", "INVALID_NUMBER"),
    SVC_FAIL("Service failed to provide resullt to desired output.Please try again", "SVC_FAILED"),
    EXCEL_FAILED("Failed to create or modify EXCEL sheet", "EXCEL_FAILED"),
    FILE_NOT_FOUND("Not able to find the appropriate excel sheet", "FILE_NOT_FOUND"),
    OBJECT_CREATN_FAILED("Error while creating Objec from JSON", "OBJECT_CREATN_FAILED"),
    NOT_DIV("Division by 0 is not allowed", "NOT_DIVISIBLE");

    private String msg;
    private String errorCode;

    ErrorMessages(String msg, String code) {
        this.msg = msg;
        this.errorCode = code;
    }

    ErrorMessages() {
    }

    public String getMsg() {
        return this.msg;
    }

    public String getCode() {
        return this.errorCode;
    }

}
