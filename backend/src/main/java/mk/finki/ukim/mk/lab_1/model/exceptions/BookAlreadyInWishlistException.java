package mk.finki.ukim.mk.lab_1.model.exceptions;

public class BookAlreadyInWishlistException extends RuntimeException {
    public BookAlreadyInWishlistException(String username, Long bookId) {
        super(String.format("Book with id: %d already exists in wishlist for user with username %s", bookId, username));
    }
}
