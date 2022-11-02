package com.fareye.training.exception;


public class ResourceNotFoundException extends Exception{

    public ResourceNotFoundException(){
        super("Git ID not found");
    }
}
