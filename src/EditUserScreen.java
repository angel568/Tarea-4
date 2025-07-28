import javax.swing.*;
import java.awt.*;

public class EditUserScreen extends JFrame {
    private JTextField usernameField, firstNameField, lastNameField, phoneField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private User user;

    public EditUserScreen(User user, Runnable onUserUpdated) {
        this.user = user;

        setTitle("Editar Usuario");
        setSize(400, 300);
        setLayout(new GridLayout(8, 2, 10, 10));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        usernameField = new JTextField(user.getUsername());
        usernameField.setEnabled(false);  // No se puede cambiar el usuario (clave primaria)
        firstNameField = new JTextField(user.getFirstName());
        lastNameField = new JTextField(user.getLastName());
        phoneField = new JTextField(user.getPhone());
        emailField = new JTextField(user.getEmail());
        passwordField = new JPasswordField(user.getPassword());
        confirmPasswordField = new JPasswordField(user.getPassword());

        add(new JLabel("Usuario:"));
        add(usernameField);
        add(new JLabel("Nombre:"));
        add(firstNameField);
        add(new JLabel("Apellido:"));
        add(lastNameField);
        add(new JLabel("Teléfono:"));
        add(phoneField);
        add(new JLabel("Correo:"));
        add(emailField);
        add(new JLabel("Contraseña:"));
        add(passwordField);
        add(new JLabel("Confirmar Contraseña:"));
        add(confirmPasswordField);

        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(e -> {
            String firstName = firstNameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            String phone = phoneField.getText().trim();
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            User updatedUser = new User(user.getUsername(), firstName, lastName, phone, email, password);
            boolean success = UserManager.updateUser(updatedUser);
            if (success) {
                JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente.");
                onUserUpdated.run();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(saveButton);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
