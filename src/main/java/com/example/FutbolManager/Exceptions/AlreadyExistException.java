package com.example.FutbolManager.Exceptions;

public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException(String value){super(" already exists");}
}
