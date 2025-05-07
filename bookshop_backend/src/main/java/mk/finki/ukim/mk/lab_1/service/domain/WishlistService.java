package mk.finki.ukim.mk.lab_1.service.domain;

import mk.finki.ukim.mk.lab_1.dto.WishlistDto;
import mk.finki.ukim.mk.lab_1.model.domain.Book;
import mk.finki.ukim.mk.lab_1.model.domain.Wishlist;

import java.util.List;
import java.util.Optional;

public interface WishlistService {
    List<Book> listAllBooksInWishlist(Long wishlistId);

    Optional<Wishlist> getActiveWishlist(String username);

    Optional<Wishlist> addBookToWishlist(String username, Long bookId);

    Optional<Wishlist> rentAllBooks(String username);
}
