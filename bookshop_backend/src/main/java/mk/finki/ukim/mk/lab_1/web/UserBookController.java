package mk.finki.ukim.mk.lab_1.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.finki.ukim.mk.lab_1.model.domain.UserBook;
import mk.finki.ukim.mk.lab_1.service.domain.UserBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rent")
@Tag(name = "Rent API", description = "API for renting books")
public class UserBookController {

    private final UserBookService userBookService;

    public UserBookController(UserBookService userBookService) {
        this.userBookService = userBookService;
    }

    @PostMapping("/{bookId}")
    @Operation(summary = "Изнајмување на книга", description = "Овој endpoint овозможува најавениот корисник да изнајми книга.")
    public ResponseEntity<UserBook> rentBook(@AuthenticationPrincipal UserDetails userDetails, @PathVariable Long bookId) {
        String username = userDetails.getUsername();  // Добиј го најавениот корисник
        UserBook rentedBook = userBookService.rent(username, bookId);
        return ResponseEntity.ok(rentedBook);
    }
}

