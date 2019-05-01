package vsu.amm.carsharingbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CarNumberAlreadyExistException extends Exception {
    public CarNumberAlreadyExistException() {
        super("Данный номер занят");
    }
}
