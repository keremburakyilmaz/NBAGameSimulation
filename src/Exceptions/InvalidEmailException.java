package Exceptions;

public class InvalidEmailException extends Exception{
    public InvalidEmailException(String error) {
        super(error);
    }
}
