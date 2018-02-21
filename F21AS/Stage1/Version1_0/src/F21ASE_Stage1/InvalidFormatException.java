package F21ASE_Stage1;

/**
 * @author Sidi Sun
 * @version 1.0
 */
public class InvalidFormatException extends RuntimeException {

    private String errMsg;  //error message

    /**
     * constructor
     */
    public InvalidFormatException() {
        super();
    }

    /**
     * constructor
     * @param message
     */
    public InvalidFormatException(String message) {
        super(message);
        this.errMsg = "Invalid format: " + message;
    }

    /**
     * get the error message
     * @return errMsg
     */
    public String getMessage() {
        return this.errMsg;
    }
}
