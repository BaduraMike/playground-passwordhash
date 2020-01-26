package com.badsoft.web.services;

public interface PasswordService {
    String hash(String input);

    String algorithm();
}
