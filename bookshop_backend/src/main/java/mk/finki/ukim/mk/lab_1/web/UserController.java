package mk.finki.ukim.mk.lab_1.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.finki.ukim.mk.lab_1.dto.createDto.CreateUserDto;
import mk.finki.ukim.mk.lab_1.dto.displayDto.DisplayUserDto;
import mk.finki.ukim.mk.lab_1.dto.loginDto.LoginResponseDto;
import mk.finki.ukim.mk.lab_1.dto.loginDto.LoginUserDto;
import mk.finki.ukim.mk.lab_1.model.domain.User;
import mk.finki.ukim.mk.lab_1.model.exceptions.InvalidArgumentsException;
import mk.finki.ukim.mk.lab_1.model.exceptions.InvalidUserCredentialsException;
import mk.finki.ukim.mk.lab_1.model.exceptions.PasswordsDoNotMatchException;
import mk.finki.ukim.mk.lab_1.service.application.UserApplicationService;
import mk.finki.ukim.mk.lab_1.service.domain.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User", description = "API for user authentication and registration") // Swagger tag
public class UserController {

    private final UserApplicationService userApplicationService;
    private final UserService userService;

    public UserController(UserApplicationService userApplicationService, UserService userService) {
        this.userApplicationService = userApplicationService;
        this.userService = userService;
    }

    @Operation(summary = "Register a new user", description = "Creates a new user account")
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200",
                    description = "User registered successfully"
            ), @ApiResponse(
                    responseCode = "400", description = "Invalid input or passwords do not match"
            )}
    )
    @PostMapping("/register")
    public ResponseEntity<LoginResponseDto> register(@RequestBody CreateUserDto createUserDto) {
        try {
            return userApplicationService.register(createUserDto)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (InvalidArgumentsException | PasswordsDoNotMatchException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "User login", description = "Authenticates a user and starts a session")
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200",
                    description = "User authenticated successfully"
            ), @ApiResponse(responseCode = "404", description = "Invalid username or password")}
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginUserDto loginUserDto) {
        try {
            return userApplicationService.login(loginUserDto)
                    .map(ResponseEntity::ok)
                    .orElseThrow(InvalidUserCredentialsException::new);
        } catch (InvalidUserCredentialsException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Get current logged-in user details", description = "Returns details of the currently authenticated user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved user details",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DisplayUserDto.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized - user is not authenticated")
    })
    @GetMapping("/me")
    public ResponseEntity<DisplayUserDto> getCurrentUserDetails(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String username = authentication.getName();

        User user = userService.findByUsername(username);
        DisplayUserDto dto = new DisplayUserDto(
                user.getUsername(),
                user.getName(),
                user.getSurname(),
                user.getRole()
        );

        return ResponseEntity.ok(dto);
    }

//    @Operation(summary = "User logout", description = "Ends the user's session")
//    @ApiResponse(responseCode = "200", description = "User logged out successfully")
//    @GetMapping("/logout")
//    public void logout(HttpServletRequest request) {
//        request.getSession().invalidate();
//    }
}

