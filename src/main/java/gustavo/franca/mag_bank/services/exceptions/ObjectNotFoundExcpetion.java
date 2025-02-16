package gustavo.franca.mag_bank.services.exceptions;

public class ObjectNotFoundExcpetion extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundExcpetion(String message){super(message);}

    public ObjectNotFoundExcpetion(Throwable cause) {
        super(cause);
    }
}
