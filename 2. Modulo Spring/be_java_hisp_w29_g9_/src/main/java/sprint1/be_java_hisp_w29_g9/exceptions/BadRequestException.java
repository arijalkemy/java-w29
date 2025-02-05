package sprint1.be_java_hisp_w29_g9.exceptions;
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}