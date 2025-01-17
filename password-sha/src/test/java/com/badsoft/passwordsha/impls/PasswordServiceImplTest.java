package com.badsoft.passwordsha.impls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import com.badsoft.web.services.PasswordService;

import static org.junit.jupiter.api.Assertions.*;

class PasswordServiceImplTest {

    private PasswordService passwordService;

    @BeforeEach
    void init(){
        passwordService = new PasswordServiceImpl();
    }

    @DisplayName("sha256 -> hex")
    @ParameterizedTest
    @CsvSource({
            "123456, 8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92",
            "hello world, b94d27b9934d3e08a52e52d7da7dabfac484efe37a5380ee9088f7ace2efcde9"
    })
    void testShw256hex(String input, String expected){
        assertEquals(expected, passwordService.hash(input));
    }
}