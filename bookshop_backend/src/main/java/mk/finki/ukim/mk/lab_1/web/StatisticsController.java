package mk.finki.ukim.mk.lab_1.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.finki.ukim.mk.lab_1.service.domain.StatisticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/statistics")
@Tag(name = "Statistics API", description = "API for statistics related to book rentals")
public class StatisticsController {

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/most-rented-book")
    @Operation(summary = "Most rented book", description = "This endpoint returns the most rented book by rental count")
    public ResponseEntity<String> getMostRentedBook() {
        String mostRentedBook = statisticsService.getMostRentedBook();
        return ResponseEntity.ok(mostRentedBook);
    }

    @GetMapping("/most-rented-author")
    @Operation(summary = "Most rented author", description = "This endpoint returns the most rented author by rental count")
    public ResponseEntity<String> getMostRentedAuthor() {
        String mostRentedAuthor = statisticsService.getMostRentedAuthor();
        return ResponseEntity.ok(mostRentedAuthor);
    }

    @GetMapping("/most-rented-user")
    @Operation(summary = "Most rented user", description = "This endpoint returns the most rented user by rental count")
    public ResponseEntity<String> getMostRentedUser() {
        String mostRentedUser = statisticsService.getMostRentedUser();
        return ResponseEntity.ok(mostRentedUser);
    }
}
