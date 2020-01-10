package impls;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import services.PasswordService;

@Service
public class PasswordServiceImpl implements PasswordService {
    @Override
    public String hash(String input) {
        return DigestUtils.sha256Hex(input);
    }

    @Override
    public String alorithm() {
        return "sha256";
    }
}
