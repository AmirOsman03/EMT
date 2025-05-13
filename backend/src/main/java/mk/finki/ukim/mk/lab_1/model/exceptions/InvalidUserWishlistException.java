package mk.finki.ukim.mk.lab_1.model.exceptions;

public class InvalidUserWishlistException extends RuntimeException {
    public InvalidUserWishlistException() {
        super("Invalid user wishlist");
    }
}
