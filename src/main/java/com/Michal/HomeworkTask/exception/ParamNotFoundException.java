package com.Michal.HomeworkTask.exception;

public class ParamNotFoundException extends RuntimeException{
    private String message;
    public ParamNotFoundException(){
        this.message = "param not found!";
    }
    public ParamNotFoundException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
