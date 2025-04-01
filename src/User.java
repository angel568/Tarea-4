public class User {
    private String username;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;

    public User(String username, String firstName, String lastName, String phone, String email, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
