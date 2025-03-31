package mk.finki.ukim.mk.lab_1.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.finki.ukim.mk.lab_1.dto.*;
import mk.finki.ukim.mk.lab_1.service.application.AuthorApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@Tag(name = "Authors", description = "API for managing authors in the library")
public class AuthorController {
    private final AuthorApplicationService authorApplicationService;

    public AuthorController(AuthorApplicationService authorApplicationService) {
        this.authorApplicationService = authorApplicationService;
    }

    // GET ALL AUTHORS METHOD
    @GetMapping
    @Operation(summary = "Get all authors", description = "Return a list of all authors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<DisplayAuthorDto> findAll() {
        return authorApplicationService.findAll();
    }

    // FIND AUTHOR METHOD
    @GetMapping("/{id}")
    @Operation(summary = "Get an author by ID", description = "Return an author based on the provided ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Author found"),
            @ApiResponse(responseCode = "404", description = "Author not found")
    })
    public ResponseEntity<DisplayAuthorDto> findById(@PathVariable Long id) {
        return authorApplicationService.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // SAVE AUTHOR METHOD
    @PostMapping("/add")
    @Operation(summary = "Add a new author", description = "Creates a new author")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Author successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<DisplayAuthorDto> save(@RequestBody CreateAuthorDto author) {
        return authorApplicationService.save(author)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // EDIT AUTHOR METHOD
    @PutMapping("/edit/{id}")
    @Operation(summary = "Edit an author", description = "Edit an existing author")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Author successfully updated"),
            @ApiResponse(responseCode = "404", description = "Author not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<DisplayAuthorDto> update(@PathVariable Long id, @RequestBody UpdateAuthorDto author) {
        return authorApplicationService.update(id, author)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE AUTHOR METHOD
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete an author", description = "Removes an existing author")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Author successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Author not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (authorApplicationService.findById(id).isPresent()) {
            authorApplicationService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
