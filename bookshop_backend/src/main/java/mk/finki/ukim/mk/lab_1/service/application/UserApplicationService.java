package mk.finki.ukim.mk.lab_1.service.application;

import mk.finki.ukim.mk.lab_1.dto.createDto.CreateUserDto;
import mk.finki.ukim.mk.lab_1.dto.displayDto.DisplayUserDto;
import mk.finki.ukim.mk.lab_1.dto.loginDto.LoginResponseDto;
import mk.finki.ukim.mk.lab_1.dto.loginDto.LoginUserDto;

import java.util.Optional;

public interface UserApplicationService {
    Optional<LoginResponseDto> register(CreateUserDto createUserDto);

    Optional<LoginResponseDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);
}
