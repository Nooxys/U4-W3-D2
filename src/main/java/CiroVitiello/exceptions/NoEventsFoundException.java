package CiroVitiello.exceptions;

import java.util.UUID;

public class NoEventsFoundException extends RuntimeException {
    public NoEventsFoundException(UUID id) {
        super("The event with " + id + " ID was not found.");
    }
}
