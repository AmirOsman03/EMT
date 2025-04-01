package mk.finki.ukim.mk.lab_1.repository;

import mk.finki.ukim.mk.lab_1.model.domain.User;
import mk.finki.ukim.mk.lab_1.model.domain.Wishlist;
import mk.finki.ukim.mk.lab_1.model.enums.WishlistStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    Optional<Wishlist> findByUserAndStatus(User user, WishlistStatus status);

    Optional<Wishlist> findByUser(User user);
}
