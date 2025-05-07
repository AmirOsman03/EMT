package mk.finki.ukim.mk.lab_1.service.domain.impl;

import mk.finki.ukim.mk.lab_1.model.domain.Book;
import mk.finki.ukim.mk.lab_1.model.domain.User;
import mk.finki.ukim.mk.lab_1.model.domain.Wishlist;
import mk.finki.ukim.mk.lab_1.model.enums.WishlistStatus;
import mk.finki.ukim.mk.lab_1.model.exceptions.*;
import mk.finki.ukim.mk.lab_1.repository.WishlistRepository;
import mk.finki.ukim.mk.lab_1.service.domain.BookService;
import mk.finki.ukim.mk.lab_1.service.domain.UserService;
import mk.finki.ukim.mk.lab_1.service.domain.WishlistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistServiceImpl implements WishlistService {
    private final WishlistRepository wishlistRepository;
    private final UserService userService;
    private final BookService bookService;

    public WishlistServiceImpl(WishlistRepository wishlistRepository, UserService userService, BookService bookService) {
        this.wishlistRepository = wishlistRepository;
        this.userService = userService;
        this.bookService = bookService;
    }

    @Override
    public List<Book> listAllBooksInWishlist(Long wishlistId) {
        if (wishlistRepository.findById(wishlistId).isEmpty())
            throw new WishlistNotFoundException(wishlistId);
        return this.wishlistRepository.findById(wishlistId).get().getBooks();
    }

    @Override
    public Optional<Wishlist> getActiveWishlist(String username) {
        User user = userService.findByUsername(username);

        return Optional.of(wishlistRepository.findByUserAndStatus(
                user,
                WishlistStatus.CREATED
        ).orElseGet(() -> wishlistRepository.save(new Wishlist(user))));
    }


    @Override
    public Optional<Wishlist> addBookToWishlist(String username, Long bookId) {
        if (getActiveWishlist(username).isPresent()) {
            Wishlist wishlist = getActiveWishlist(username).get();

            Book book = bookService.findById(bookId)
                    .orElseThrow(() -> new BookNotFoundException(bookId));

            if (!wishlist.getBooks().stream().filter(e -> e.getId().equals(bookId)).toList().isEmpty())
                throw new BookAlreadyInWishlistException(username, bookId);
            wishlist.getBooks().add(book);
            return Optional.of(wishlistRepository.save(wishlist));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Wishlist> rentAllBooks(String username) {
        User user = userService.findByUsername(username);

        Wishlist wishlist = wishlistRepository.findByUser(user)
                .orElseThrow(InvalidUserWishlistException::new);

        if (wishlist.getBooks().isEmpty()) throw new EmptyWishlistException();

        for (Book book : wishlist.getBooks()) {
            if (book.getAvailableCopies() <= 0) throw new EmptyBookCopiesException();
        }

        for (Book book : wishlist.getBooks()) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            bookService.save(book);
        }

        wishlist.getBooks().clear();
        wishlistRepository.save(wishlist);
        return Optional.of(wishlist);
    }
}
