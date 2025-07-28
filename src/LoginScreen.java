import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginScreen() {
        setTitle("Inicio de Sesión");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Usuario:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Contraseña:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Debe ingresar su usuario y contraseña, si no está registrado debe registrarse.",
                        "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            User usuario = UserManager.authenticate(username, password);
            if (usuario != null) {
                new UserListScreen();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(loginButton);

        JButton registerButton = new JButton("Registrarse");
        registerButton.addActionListener(e -> new RegisterScreen());
        add(registerButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}