import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterScreen extends JFrame {
    private JTextField usernameField, firstNameField, lastNameField, phoneField, emailField;
    private JPasswordField passwordField, confirmPasswordField;

    public RegisterScreen() {
        setTitle("Registro de Usuario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(8, 2, 10, 10));

        add(new JLabel("Usuario:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Nombre:"));
        firstNameField = new JTextField();
        add(firstNameField);

        add(new JLabel("Apellido:"));
        lastNameField = new JTextField();
        add(lastNameField);

        add(new JLabel("Teléfono:"));
        phoneField = new JTextField();
        add(phoneField);

        add(new JLabel("Correo:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Contraseña:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("Confirmar Contraseña:"));
        confirmPasswordField = new JPasswordField();
        add(confirmPasswordField);

        JButton registerButton = new JButton("Registrar");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                UserManager.addUser(new User(username, firstName, lastName, phone, email, password));
                JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");

                dispose();
            }
        });

        add(registerButton);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
