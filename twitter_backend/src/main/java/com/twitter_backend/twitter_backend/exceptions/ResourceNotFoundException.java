package com.twitter_backend.twitter_backend.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
  
    public ResourceNotFoundException(String msg) {
      super(msg);
    }
  }