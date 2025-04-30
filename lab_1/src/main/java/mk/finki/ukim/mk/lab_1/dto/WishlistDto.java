package mk.finki.ukim.mk.lab_1.dto;

import mk.finki.ukim.mk.lab_1.dto.displayDto.DisplayBookDto;
import mk.finki.ukim.mk.lab_1.dto.displayDto.DisplayUserDto;
import mk.finki.ukim.mk.lab_1.model.domain.Wishlist;
import mk.finki.ukim.mk.lab_1.model.enums.WishlistStatus;

import java.time.LocalDateTime;
import java.util.List;

public record WishlistDto (
        Long id,
        LocalDateTime dateCreated,
        DisplayUserDto user,
        List<DisplayBookDto> books,
        WishlistStatus status
) {
    public static WishlistDto from(Wishlist wishlist) {
        return new WishlistDto(
                wishlist.getId(),
                wishlist.getDateCreated(),
                DisplayUserDto.from(wishlist.getUser()),
                DisplayBookDto.from(wishlist.getBooks()),
                wishlist.getStatus()
        );
    }
}
