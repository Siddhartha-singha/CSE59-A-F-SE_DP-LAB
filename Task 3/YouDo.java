//user info
public class User {
    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    // create email validator

    public static class EmailValidator {
        public static boolean isValid(String email) {
            return email != null && email.contains("@");
        }
    }

    // create user repository

    public static class UserRepository {
        public void save(User user) {
            if (EmailValidator.isValid(user.getEmail())) {
                System.out.println("connecting to database...");
                System.out.println("saving user " + user.getUsername() + " to the user table");
            } else {
                System.out.println("Invalid email format");
            }
        }
    }
}
