package com.example.demo.cache.exceptions;

public class StorageFullException extends RuntimeException {
    public StorageFullException(String message) {
        super(message);
    }
}

