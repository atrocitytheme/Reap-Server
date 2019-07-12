package server.reaptheflag.reaptheflag.renderserver.transferer.impl;

import server.reaptheflag.reaptheflag.renderserver.transferer.TokenValidator;

public class TokenChecker implements TokenValidator {
    @Override
    public boolean validateToken(String token) {
        return true;
    }
}
