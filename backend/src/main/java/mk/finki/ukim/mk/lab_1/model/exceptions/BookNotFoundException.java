package mk.finki.ukim.mk.lab_1.model.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long bookId) {
        super(String.format("Book with id: %d not found", bookId));
    }
}
