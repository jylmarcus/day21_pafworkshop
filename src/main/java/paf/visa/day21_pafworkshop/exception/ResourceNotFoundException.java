package paf.visa.day21_pafworkshop.exception;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(){
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    } 

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
