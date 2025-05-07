package mk.finki.ukim.mk.lab_1.service.domain.impl;

import mk.finki.ukim.mk.lab_1.model.domain.Book;
import mk.finki.ukim.mk.lab_1.model.domain.User;
import mk.finki.ukim.mk.lab_1.model.domain.UserBook;
import mk.finki.ukim.mk.lab_1.repository.BookRepository;
import mk.finki.ukim.mk.lab_1.repository.UserBookRepository;
import mk.finki.ukim.mk.lab_1.repository.UserRepository;
import mk.finki.ukim.mk.lab_1.service.domain.UserBookService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserBookServiceImpl implements UserBookService {
    private final UserBookRepository userBookRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public UserBookServiceImpl(UserBookRepository userBookRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.userBookRepository = userBookRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserBook rent(String userId, Long bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        UserBook userBook = new UserBook();
        userBook.setUser(user);
        userBook.setBook(book);
        userBook.setRentedAt(LocalDateTime.now());

        return userBookRepository.save(userBook);
    }
}
