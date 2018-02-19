package F21ASE_Stage1;

/**
 * @author Sidi Sun
 * @version 1.0
 */
public class InvalidFormatException extends RuntimeException {

    private String errMsg;  //error message

    public InvalidFormatException() {
        super();
    }

    public InvalidFormatException(String message) {
        super(message);
        this.errMsg = "Invalid format: " + message;
    }

    public String getMessage() {
        return this.errMsg;
    }
}
