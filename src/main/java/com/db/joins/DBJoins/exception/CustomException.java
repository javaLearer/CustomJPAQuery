package com.db.joins.DBJoins.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = -661517543912610542L;
    public CustomException() {
    }

    public CustomException(String custommsg) {
        super(custommsg);
        this.custommsg=custommsg;
    }

    public String getCustommsg() {
        return custommsg;
    }

    public void setCustommsg(String custommsg) {
        this.custommsg = custommsg;
    }

    private String custommsg;

    //@ResponseStatus(HttpStatus.NOT_FOUND)
    public void getExceptionDetails()
    {
        System.out.println(this.getCustommsg());
    }


}
