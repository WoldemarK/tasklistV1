package com.example.tasklist.service;

import com.example.tasklist.dto.auth.JwtRequest;
import com.example.tasklist.dto.auth.JwtResponse;

public interface AuthService {
    JwtResponse login(JwtRequest loginRequest);
    JwtResponse refresh(String refreshToken);

}
