package mk.finki.ukim.mk.lab_1.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.lab_1.dto.WishlistDto;
import mk.finki.ukim.mk.lab_1.model.domain.User;
import mk.finki.ukim.mk.lab_1.service.application.WishlistApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wishlists")
@Tag(name = "Wishlist", description = "API for managing the wishlists")
public class WishlistController {
    private final WishlistApplicationService wishlistApplicationService;

    public WishlistController(WishlistApplicationService wishlistApplicationService) {
        this.wishlistApplicationService = wishlistApplicationService;
    }

    @Operation(summary = "Get active wishlist", description = "Fetches the active wishlist for the authenticated user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched the wishlist"),
            @ApiResponse(responseCode = "404", description = "Wishlist not found")
    })
    @GetMapping
    public ResponseEntity<WishlistDto> getActiveShoppingCart(HttpServletRequest req) {
        String username = req.getRemoteUser();

        return wishlistApplicationService.getActiveShoppingCart(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Add a product to the wishlist", description = "Adds a book to the wishlist of the authenticated user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added the product to the wishlist"),
            @ApiResponse(responseCode = "404", description = "Wishlist not found"),
            @ApiResponse(responseCode = "400", description = "Bad request, failed to add book")
    })
    @PostMapping("/add-book/{id}")
    public ResponseEntity<WishlistDto> addBookToWishlist(
            @PathVariable Long id,
            Authentication authentication
    ) {
        try {
            User user = (User) authentication.getPrincipal();
            return wishlistApplicationService.addBookToWishlist(user.getUsername(), id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Rent all books in the wishlist", description = "Rents all books in the wishlist for the authenticated user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully rented all books"),
            @ApiResponse(responseCode = "400", description = "Bad request, failed to rent books"),
            @ApiResponse(responseCode = "404", description = "Wishlist not found")
    })
    @PostMapping("/rent-all-books")
    public ResponseEntity<WishlistDto> rentAllBooks(Authentication authentication) {
        try {
            User user = (User) authentication.getPrincipal();

            return wishlistApplicationService.rentAllBooks(user.getUsername())
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.badRequest().build());
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().build();
        }
    }
}
