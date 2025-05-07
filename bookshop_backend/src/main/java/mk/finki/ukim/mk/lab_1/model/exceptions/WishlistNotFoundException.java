package mk.finki.ukim.mk.lab_1.model.exceptions;

public class WishlistNotFoundException extends RuntimeException {
    public WishlistNotFoundException(Long wishlistId) {
        super(String.format("Wishlist with id: %d was not found", wishlistId));
    }
}
