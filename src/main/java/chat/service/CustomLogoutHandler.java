package chat.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomLogoutHandler implements LogoutHandler {
    private AuthoritiesUser authoritiesUser;

    public CustomLogoutHandler(AuthoritiesUser authoritiesUser) {
        this.authoritiesUser = authoritiesUser;
    }

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        authoritiesUser.deleteAuthoritiesUsername(authentication.getName());
    }
}
