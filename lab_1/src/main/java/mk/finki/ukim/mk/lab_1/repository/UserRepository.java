package mk.finki.ukim.mk.lab_1.repository;

import mk.finki.ukim.mk.lab_1.model.domain.User;
import mk.finki.ukim.mk.lab_1.model.enums.Role;
import mk.finki.ukim.mk.lab_1.model.projections.UserProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);

    @EntityGraph(
            type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"carts"}
    )
    @Query("select u from User u")
    List<User> fetchAllCarts();

    @EntityGraph(
            type = EntityGraph.EntityGraphType.LOAD,
            attributePaths = {"carts"}
    )
    @Query("select u from User u")
    List<User> loadAllCarts();

    UserProjection findByRole(Role role);

    @Query("select u.username, u.name, u.surname from User u")
    List<UserProjection> takeUsernameAndNameAndSurnameByProjection();

    @EntityGraph(
            type = EntityGraph.EntityGraphType.LOAD,
            attributePaths = {"wishlists"}
    )
    @Query("select u from User u")
    List<User> loadAllWishlists();

    // FETCH -> we will get the user we will get all the carts with him
    // LOAD -> we will get the user, BUT if we NEED the carts we have to get them explicitly

}

