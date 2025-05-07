package mk.finki.ukim.mk.lab_1.model.exceptions;

public class EmptyWishlistException extends RuntimeException {
    public EmptyWishlistException() {
        super("Wishlist is empty");
    }
}
