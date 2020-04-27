package com.wplnt.akshay.waterPlant.exception;

public class ApplicationException extends Exception {

    private static final long serialVersionUID = 7718828512143293558L;


    private ErrorMessages errorMsg;

    public ApplicationException(ErrorMessages errorMsg) {
        super(errorMsg.getMsg());
        this.errorMsg = errorMsg;
    }

    public ApplicationException(Throwable cause, ErrorMessages errorMsg) {
        super(errorMsg.getMsg());
        this.errorMsg = errorMsg;
    }
}
