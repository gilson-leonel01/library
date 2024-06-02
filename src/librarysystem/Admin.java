public class Admin extends Person {
    private String adminCode;

    public Admin(String name, int age, String email, String adminCode) {
        super(name, age, email);
        this.adminCode = adminCode;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public void grantAccess() {
        System.out.println("Admin access granted with code: " + adminCode);
    }

    public void registerBook(String title, String author, String isbn, int yearPublished) {
        if (isAdmin()) {
            Book newBook = new Book(title, author, isbn, yearPublished);
            System.out.println("Book registered successfully:");
            System.out.println(newBook);
        } else {
            System.out.println("Access denied. Insufficient privileges to register a book.");
        }
    }

    private boolean isAdmin() {
        return adminCode.equals("admin123");
    }
}
