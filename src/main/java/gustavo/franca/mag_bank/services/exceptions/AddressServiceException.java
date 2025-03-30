package gustavo.franca.mag_bank.services.exceptions;

public class AddressServiceException extends RuntimeException{
    public AddressServiceException(String message) {
        super(message);
    }

    public AddressServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
