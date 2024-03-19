package CiroVitiello.exceptions;

public class NoEventsFoundException extends RuntimeException {
    public NoEventsFoundException(long id) {
        super("The event with " + id + " ID was not found.");
    }
}
