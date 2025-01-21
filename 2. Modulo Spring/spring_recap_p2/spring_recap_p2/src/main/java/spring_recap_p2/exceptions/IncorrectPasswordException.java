package spring_recap_p2.exceptions;

public class IncorrectPasswordException extends RuntimeException {
  public IncorrectPasswordException(String message){
    super(message);
  }
}
