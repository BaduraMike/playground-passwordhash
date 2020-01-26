package com.badsoft.passwordsha.impls;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import com.badsoft.web.services.PasswordService;

@Service
public class PasswordServiceImpl implements PasswordService {
    @Override
    public String hash(String input) {
        return DigestUtils.sha256Hex(input);
    }

    @Override
    public String algorithm() {
        return "sha256";
    }
}
