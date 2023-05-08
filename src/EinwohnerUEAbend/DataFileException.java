package EinwohnerUEAbend;

public class DataFileException extends Exception{

    public DataFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataFileException(String message) {
        super(message);
    }
}
