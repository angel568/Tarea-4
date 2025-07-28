import javax.swing.*;
import java.awt.*;

public class RegisterScreen extends JFrame {
    private JTextField usernameField, firstNameField, lastNameField, phoneField, emailField;
    private JPasswordField passwordField, confirmPasswordField;

    public RegisterScreen() {
        setTitle("Registro de Usuario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(8, 2, 10, 10));

        usernameField = new JTextField();
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        phoneField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();

        add(new JLabel("Usuario:")); add(usernameField);
        add(new JLabel("Nombre:")); add(firstNameField);
        add(new JLabel("Apellido:")); add(lastNameField);
        add(new JLabel("Teléfono:")); add(phoneField);
        add(new JLabel("Correo:")); add(emailField);
        add(new JLabel("Contraseña:")); add(passwordField);
        add(new JLabel("Confirmar Contraseña:")); add(confirmPasswordField);

        JButton registerButton = new JButton("Registrar");
        registerButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String firstName = firstNameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            String phone = phoneField.getText().trim();
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (username.isEmpty() || firstName.isEmpty() || lastName.isEmpty() ||
                    phone.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (UserManager.getUserByUsername(username) != null) {
                JOptionPane.showMessageDialog(null, "El nombre de usuario ya está registrado.", "Usuario existente", JOptionPane.ERROR_MESSAGE);
                return;
            }

            User nuevoUsuario = new User(username, firstName, lastName, phone, email, password);
            UserManager.addUser(nuevoUsuario);
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");
            dispose();
        });
        add(registerButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}