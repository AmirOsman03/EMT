package mk.finki.ukim.mk.lab_1.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.finki.ukim.mk.lab_1.dto.createDto.CreateCountryDto;
import mk.finki.ukim.mk.lab_1.dto.displayDto.DisplayCountryDto;
import mk.finki.ukim.mk.lab_1.dto.updateDto.UpdateCountryDto;
import mk.finki.ukim.mk.lab_1.service.application.CountryApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@Tag(name = "Countries", description = "API for managing countries")
public class CountryController {
    private final CountryApplicationService countryApplicationService;

    public CountryController(CountryApplicationService countryApplicationService) {
        this.countryApplicationService = countryApplicationService;
    }

    // GET ALL COUNTRIES
    @GetMapping
    @Operation(summary = "Get all countries", description = "Returns a list of all countries")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<DisplayCountryDto> findAll() {
        return countryApplicationService.findAll();
    }

    // FIND COUNTRY BY ID
    @GetMapping("/{id}")
    @Operation(summary = "Get a country by ID", description = "Returns a country based on the provided ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Country found"),
            @ApiResponse(responseCode = "404", description = "Country not found")
    })
    public ResponseEntity<DisplayCountryDto> findById(@PathVariable Long id) {
        return countryApplicationService.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // SAVE COUNTRY
    @PostMapping("/add")
    @Operation(summary = "Add a new country", description = "Creates a new country")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Country successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<DisplayCountryDto> save(@RequestBody CreateCountryDto country) {
        return countryApplicationService.save(country)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // EDIT COUNTRY
    @PutMapping("/edit/{id}")
    @Operation(summary = "Edit a country", description = "Edits an existing country")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Country successfully updated"),
            @ApiResponse(responseCode = "404", description = "Country not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<DisplayCountryDto> update(@PathVariable Long id, @RequestBody UpdateCountryDto country) {
        return countryApplicationService.update(id, country)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE COUNTRY
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a country", description = "Removes an existing country")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Country successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Country not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (countryApplicationService.findById(id).isPresent()) {
            countryApplicationService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}