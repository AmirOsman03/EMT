package mk.finki.ukim.mk.lab_1.model.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class UserBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // Poveke userBooks moze da ima eden korisnik
    @ManyToOne
    private User user;

    // Poveke userbooks moze da ima edna kniga
    @ManyToOne
    private Book book;

    private LocalDateTime rentedAt;

    public UserBook() {
        this.rentedAt = LocalDateTime.now();
    }
}
