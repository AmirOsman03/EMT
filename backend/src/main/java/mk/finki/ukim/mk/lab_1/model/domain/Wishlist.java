package mk.finki.ukim.mk.lab_1.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import mk.finki.ukim.mk.lab_1.model.enums.WishlistStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateCreated;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Book> books;

    @Enumerated(EnumType.STRING)
    private WishlistStatus status;

    public Wishlist() {}

    public Wishlist(User user) {
        this.dateCreated = LocalDateTime.now();
        this.user = user;
        this.books = new ArrayList<>();
        this.status = WishlistStatus.CREATED;
    }
}
