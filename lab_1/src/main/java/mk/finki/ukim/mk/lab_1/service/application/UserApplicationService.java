package mk.finki.ukim.mk.lab_1.service.application;

import mk.finki.ukim.mk.lab_1.dto.CreateUserDto;
import mk.finki.ukim.mk.lab_1.dto.DisplayUserDto;
import mk.finki.ukim.mk.lab_1.dto.LoginResponseDto;
import mk.finki.ukim.mk.lab_1.dto.LoginUserDto;

import java.util.Optional;

public interface UserApplicationService {
    Optional<LoginResponseDto> register(CreateUserDto createUserDto);

    Optional<LoginResponseDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);
}
