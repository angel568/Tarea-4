import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginScreen() {
        setTitle("Inicio de Sesión");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        // Campos de entrada
        add(new JLabel("Usuario:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Contraseña:"));
        passwordField = new JPasswordField();
        add(passwordField);

        // Botón de login
        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (UserManager.authenticate(username, password) != null) {
                    new UserListScreen();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(loginButton);

        // Botón de registro
        JButton registerButton = new JButton("Registrarse");
        registerButton.addActionListener(e -> new RegisterScreen());
        add(registerButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
