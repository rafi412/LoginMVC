package dad.login;

import dad.login.model.AuthenticationService;
import dad.login.model.User;
import dad.login.view.LoginView;

public class Main2 {

    public static void main(String[] args) {
        AuthenticationService authService = new AuthenticationService();
        LoginView loginView = new LoginView();

        loginView.setLoginListener(user -> {
            boolean useLdap = true; // Indicar si se usa LDAP o el archivo
            boolean isAuthenticated = authService.authenticateUser(user, useLdap);

            if (isAuthenticated) {
                System.out.println("Inicio de sesión exitoso para el usuario: " + user.getUsername());
            } else {
                System.out.println("Inicio de sesión fallido para el usuario: " + user.getUsername());
            }
        });

        loginView.setVisible(true);
    }
}
