package backend;

public class User {
    private final int username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private UserType userType;

    public User(int username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    // No password getter yet. I'm not sure how we want to implement the authentication
    // logic, but typically the user password isn't accessed by the client.

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public UserType getUserType() {
        return userType;
    }
}