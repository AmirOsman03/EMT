package mk.finki.ukim.mk.lab_1.service.application.impl;

import mk.finki.ukim.mk.lab_1.dto.DisplayBookDto;
import mk.finki.ukim.mk.lab_1.dto.WishlistDto;
import mk.finki.ukim.mk.lab_1.service.application.WishlistApplicationService;
import mk.finki.ukim.mk.lab_1.service.domain.UserService;
import mk.finki.ukim.mk.lab_1.service.domain.WishlistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistApplicationServiceImpl implements WishlistApplicationService {
    private final WishlistService wishlistService;

    public WishlistApplicationServiceImpl(WishlistService wishlistService, UserService userService) {
        this.wishlistService = wishlistService;
    }

    @Override
    public Optional<WishlistDto> addBookToWishlist(String username, Long bookId) {
        return wishlistService.addBookToWishlist(username, bookId).map(WishlistDto::from);
    }

    @Override
    public Optional<WishlistDto> rentAllBooks(String username) {
        return wishlistService.rentAllBooks(username).map(WishlistDto::from);
    }

    @Override
    public List<DisplayBookDto> listAllBooksInWishlist(Long wishlistId) {
        return DisplayBookDto.from(wishlistService.listAllBooksInWishlist(wishlistId));
    }

    @Override
    public Optional<WishlistDto> getActiveShoppingCart(String username) {
        return wishlistService.getActiveWishlist(username).map(WishlistDto::from);
    }
}
