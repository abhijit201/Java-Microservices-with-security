package com.olx.masterdata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.olx.masterdata.utils.ExceptionConstants;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class InvalidStatusIdException extends RuntimeException {

    private int category;

    public InvalidStatusIdException() {

    }

    public InvalidStatusIdException(int category) {
        super();
        this.category = category;
    }

    @Override
    public String toString() {
        return ExceptionConstants.INVALID_STATUS_ID + this.category;
    }
}
