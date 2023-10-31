package dad.login.model;

import java.awt.event.ActionEvent;

import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;

public class AuthenticationService {
    private AuthService ldapAuthService;
    private AuthService fileAuthService;

    public AuthenticationService() {
        ldapAuthService = new LdapAuthService();
        fileAuthService = new FileAuthService();
    }

    public boolean authenticateUser(ActionEvent user, boolean useLdap) {
        AuthService authService = useLdap ? ldapAuthService : fileAuthService;
        try {
            return authService.login(user.getUsername(), user.getPassword());
        } catch (Exception e) {
            return false;
        }
    }
}
