package mk.finki.ukim.mk.lab_1.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.finki.ukim.mk.lab_1.model.Book;
import mk.finki.ukim.mk.lab_1.model.dto.BookDto;
import mk.finki.ukim.mk.lab_1.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Books", description = "API for managing books in the library")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //GET ALL BOOKS METHOD
    @GetMapping
    @Operation(summary = "Get all books", description = "Return a list of all books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<Book> findAll() {
        return bookService.findAll();
    }

    //FIND BOOK METHOD
    @GetMapping("/{id}")
    @Operation(summary = "Get a book by ID", description = "Return a book based on the provided ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book found"),
            @ApiResponse(responseCode = "404", description = "Book not found")
    })
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return bookService.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //SAVE BOOK METHOD
    @PostMapping("/add")
    @Operation(summary = "Add a new book", description = "Creates a new book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Book successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<Book> save(@RequestBody BookDto book) {
        return bookService.save(book)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //EDIT BOOK METHOD
    @PutMapping("/edit/{id}")
    @Operation(summary = "Edit a book", description = "Edit an existing book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book successfully updated"),
            @ApiResponse(responseCode = "404", description = "Book not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody BookDto book) {
        return bookService.update(id, book)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //DELETE BOOK METHOD
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete book", description = "Removes a existing book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Book not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (bookService.findById(id).isPresent()) {
            bookService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    //SEARCH BOOK METHOD
    @GetMapping("/search")
    @Operation(summary = "Search a book", description = "Search a book by its name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Book not found")
    })
    public List<Book> searchBooksByName(@RequestParam String name) {
        if (name != null) {
            return bookService.findByName(name);
        }
        return bookService.findAll();
    }
}
