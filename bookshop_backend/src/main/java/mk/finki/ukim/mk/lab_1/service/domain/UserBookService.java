package mk.finki.ukim.mk.lab_1.service.domain;

import mk.finki.ukim.mk.lab_1.model.domain.UserBook;

import java.util.Optional;

public interface UserBookService {
    UserBook rent(String userId, Long bookId);
}
