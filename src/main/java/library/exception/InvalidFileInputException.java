package library.exception;

//Custom Exception for handling if files have different number of lines.
public class InvalidFileInputException extends Exception {

    public InvalidFileInputException(String message) {
        super(message);
    }
}
