package exceptions;

public class InvalidClientTypeException extends Exception {
    
    public InvalidClientTypeException(String errorMessage)
    {
      super(errorMessage);
    }
}
