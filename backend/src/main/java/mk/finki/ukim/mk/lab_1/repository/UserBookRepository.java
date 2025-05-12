package mk.finki.ukim.mk.lab_1.repository;

import mk.finki.ukim.mk.lab_1.model.domain.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBookRepository extends JpaRepository<UserBook, Long> {

    @Query("SELECT b.name, COUNT(ub) FROM UserBook ub JOIN ub.book b GROUP BY b.name ORDER BY COUNT(ub) DESC")
    List<Object[]> findMostRentedBook();

    @Query("SELECT b.author, COUNT(ub) FROM UserBook ub JOIN ub.book b GROUP BY b.author ORDER BY COUNT(ub) DESC")
    List<Object[]> findMostRentedAuthor();

    @Query("SELECT ub.user.username, COUNT(ub) FROM UserBook ub GROUP BY ub.user.username ORDER BY COUNT(ub) DESC")
    List<Object[]> findMostRentedUser();

}
