package me.shinsunyoung.springboot_blogProject.service;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springboot_blogProject.domain.RefreshToken;
import me.shinsunyoung.springboot_blogProject.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken){
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()-> new IllegalArgumentException("Unexpected token"));
    }

}
