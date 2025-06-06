package mk.finki.ukim.mk.lab_1.service.application;

import mk.finki.ukim.mk.lab_1.dto.displayDto.DisplayBookDto;
import mk.finki.ukim.mk.lab_1.dto.WishlistDto;

import java.util.List;
import java.util.Optional;

public interface WishlistApplicationService {
    List<DisplayBookDto> listAllBooksInWishlist(Long wishlistId);

    Optional<WishlistDto> getActiveShoppingCart(String username);

    Optional<WishlistDto> addBookToWishlist(String username, Long bookId);

    Optional<WishlistDto> rentAllBooks(String username);
}
