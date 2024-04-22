package org.rd99.exception;

public class ParkingLotException extends RuntimeException{
    public ParkingLotException(){

    }
    public ParkingLotException(String message){
        super(message);
    }
}
