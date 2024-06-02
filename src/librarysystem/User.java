import java.util.Random;

public class User extends Person {
    private String username;
    private String password;
    private boolean loggedIn;
    private boolean hasBook;

    public User(String name, int age, String email, String username, String password) {
        super(name, age, email);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean hasBook() {
        return hasBook;
    }

    public void setHasBook(boolean hasBook) {
        this.hasBook = hasBook;
    }

    public void login(String username, String password) {
        if (username != null && password != null && username.equals(this.username) && password.equals(this.password)) {
            this.loggedIn = true;
            System.out.println("Logged in as user: " + username);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public void logout() {
        if (loggedIn) {
            this.loggedIn = false;
            System.out.println("Logged out.");
        } else {
            System.out.println("User is not logged in.");
        }
    }

    public void recoveryPassword() {
        System.out.println("Password recovery process initiated for user: " + getUsername());
        String temporaryPassword = generateRandomPassword();
        sendPasswordResetEmail(temporaryPassword);
        System.out.println("Password recovery email sent to: " + getEmail());
    }

    private String generateRandomPassword() {
        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String NUMBER = "0123456789";

        String combinedChars = CHAR_LOWER + CHAR_UPPER + NUMBER;

        Random random = new Random();
        StringBuilder sb = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(combinedChars.length());
            sb.append(combinedChars.charAt(index));
        }

        return sb.toString();
    }

    private void sendPasswordResetEmail(String temporaryPassword) {
        System.out.println("Password reset email sent. Temporary password: " + temporaryPassword);
    }

    public void updateInfo(String newName, int newAge, String newEmail) {
        if (loggedIn) {
            if (newName != null && !newName.isEmpty() && newEmail != null && !newEmail.isEmpty()) {
                this.name = newName;
                this.age = newAge;
                this.email = newEmail;
                System.out.println("User information updated successfully.");
            } else {
                System.out.println("Invalid new name or email.");
            }
        } else {
            System.out.println("User is not logged in.");
        }
    }

    public void requestBookLoan() {
        if (loggedIn && !hasBook) {
            hasBook = true;
            System.out.println("Book loan requested successfully.");
        } else if (loggedIn && hasBook) {
            System.out.println("You already have a book on loan.");
        } else {
            System.out.println("You must be logged in to request a book loan.");
        }
    }

    public void returnBook() {
        if (loggedIn && hasBook) {
            hasBook = false;
            System.out.println("Book returned successfully.");
        } else if (loggedIn && !hasBook) {
            System.out.println("You do not have any book on loan to return.");
        } else {
            System.out.println("You must be logged in to return a book.");
        }
    }
}
