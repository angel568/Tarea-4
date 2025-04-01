import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserListScreen extends JFrame {
    private JTable userTable;
    private DefaultTableModel tableModel;

    public UserListScreen() {
        setTitle("Clientes Registrados");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tabla de clientes
        String[] columnNames = {"Nombre", "Apellido", "Teléfono", "Correo Electrónico", "Usuario"};
        tableModel = new DefaultTableModel(columnNames, 0);
        userTable = new JTable(tableModel);
        refreshTable();

        add(new JScrollPane(userTable), BorderLayout.CENTER);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4, 10, 10));

        JButton newUserButton = new JButton("NUEVO");
        newUserButton.addActionListener(e -> new RegisterScreen());
        buttonPanel.add(newUserButton);

        JButton updateButton = new JButton("ACTUALIZAR");
        updateButton.addActionListener(e -> refreshTable());
        buttonPanel.add(updateButton);

        JButton deleteButton = new JButton("ELIMINAR");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = userTable.getSelectedRow();
                if (selectedRow >= 0) {
                    UserManager.removeUser(selectedRow);
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un usuario para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                }
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
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        List<User> users = UserManager.getUsers();
        for (User user : users) {
            tableModel.addRow(new Object[]{user.getFirstName(), user.getLastName(), user.getPhone(), user.getEmail(), user.getUsername()});
        }
    }
}
