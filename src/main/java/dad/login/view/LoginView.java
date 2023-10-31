package dad.login.view;

import dad.login.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private ActionListener loginListener;

    public LoginView() {
        setTitle("Inicio de Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2);

        JLabel usernameLabel = new JLabel("Usuario:");
        JLabel passwordLabel = new JLabel("Contraseña");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Iniciar Sesión");

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel());
        add(loginButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            User user = new User(username, password);

            if (loginListener != null) {
                loginListener.actionPerformed(e);
            }
        });
    }

    public void setLoginListener(ActionListener listener) {
        loginListener = listener;
    }
}
