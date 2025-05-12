package mk.finki.ukim.mk.lab_1.model.exceptions;

public class EmptyBookCopiesException extends RuntimeException {
    public EmptyBookCopiesException() {
        super("Book copies cannot be empty");
    }
}
