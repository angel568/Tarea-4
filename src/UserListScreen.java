import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UserListScreen extends JFrame {
    private JTable userTable;
    private DefaultTableModel tableModel;

    public UserListScreen() {
        setTitle("Clientes Registrados");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        String[] columnNames = {"Nombre", "Apellido", "Teléfono", "Correo Electrónico", "Usuario"};
        tableModel = new DefaultTableModel(columnNames, 0);
        userTable = new JTable(tableModel);
        refreshTable();

        add(new JScrollPane(userTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));

        JButton newUserButton = new JButton("NUEVO");
        newUserButton.addActionListener(e -> new RegisterScreen());
        buttonPanel.add(newUserButton);

        JButton updateButton = new JButton("ACTUALIZAR");
        updateButton.addActionListener(e -> refreshTable());
        buttonPanel.add(updateButton);

        JButton deleteButton = new JButton("ELIMINAR");
        deleteButton.addActionListener(e -> {
            int selectedRow = userTable.getSelectedRow();
            if (selectedRow >= 0) {
                String username = (String) tableModel.getValueAt(selectedRow, 4);
                UserManager.deleteUser(username);
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona un usuario para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonPanel.add(deleteButton);

        JButton logoutButton = new JButton("CERRAR SESIÓN");
        logoutButton.addActionListener(e -> {
            new LoginScreen();
            dispose();
        });
        buttonPanel.add(logoutButton);

        add(buttonPanel, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);

        JButton editButton = new JButton("EDITAR");
        editButton.addActionListener(e -> {
            int selectedRow = userTable.getSelectedRow();
            if (selectedRow >= 0) {
                String username = (String) tableModel.getValueAt(selectedRow, 4);
                User user = UserManager.getUserByUsername(username);
                if (user != null) {
                    new EditUserScreen(user, () -> refreshTable());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona un usuario para editar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonPanel.add(editButton);
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        List<User> users = UserManager.getAllUsers();
        for (User user : users) {
            tableModel.addRow(new Object[]{user.getFirstName(), user.getLastName(), user.getPhone(), user.getEmail(), user.getUsername()});
        }
    }
}
