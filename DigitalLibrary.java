import java.util.*;

class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    @Override
    public String toString() {
        return id + " - " + title + " by " + author + (isIssued ? " [Issued]" : " [Available]");
    }
}

class Member {
    int id;
    String name;

    Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

public class DigitalLibrary {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> members = new ArrayList<>();

    public static void main(String[] args) {
        // Dummy data
        books.add(new Book(1, "Java Programming", "James Gosling"));
        books.add(new Book(2, "Data Structures", "Mark Allen Weiss"));
        members.add(new Member(1, "Alice"));
        members.add(new Member(2, "Bob"));

        while (true) {
            System.out.println("\n--- DIGITAL LIBRARY ---");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> adminMenu();
                case 2 -> userMenu();
                case 3 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }

    // ---------------- ADMIN -----------------
    static void adminMenu() {
        while (true) {
            System.out.println("\n--- ADMIN MENU ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Add Member");
            System.out.println("4. Remove Member");
            System.out.println("5. View All Books");
            System.out.println("6. View All Members");
            System.out.println("7. Logout");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> addMember();
                case 4 -> removeMember();
                case 5 -> viewBooks();
                case 6 -> viewMembers();
                case 7 -> { return; }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        books.add(new Book(id, title, author));
        System.out.println("Book Added!");
    }

    static void removeBook() {
        System.out.print("Enter Book ID to Remove: ");
        int id = sc.nextInt();
        books.removeIf(b -> b.id == id);
        System.out.println("Book Removed!");
    }

    static void addMember() {
        System.out.print("Enter Member ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        members.add(new Member(id, name));
        System.out.println("Member Added!");
    }

    static void removeMember() {
        System.out.print("Enter Member ID to Remove: ");
        int id = sc.nextInt();
        members.removeIf(m -> m.id == id);
        System.out.println("Member Removed!");
    }

    // ---------------- USER -----------------
    static void userMenu() {
        while (true) {
            System.out.println("\n--- USER MENU ---");
            System.out.println("1. View Books");
            System.out.println("2. Search Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Logout");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> viewBooks();
                case 2 -> searchBook();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 5 -> { return; }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }

    static void viewBooks() {
        System.out.println("\n--- BOOKS LIST ---");
        for (Book b : books) System.out.println(b);
    }

    static void searchBook() {
        System.out.print("Enter Book Title Keyword: ");
        String keyword = sc.nextLine().toLowerCase();
        for (Book b : books) {
            if (b.title.toLowerCase().contains(keyword)) {
                System.out.println(b);
            }
        }
    }

    static void issueBook() {
        System.out.print("Enter Book ID to Issue: ");
        int id = sc.nextInt();
        for (Book b : books) {
            if (b.id == id && !b.isIssued) {
                b.isIssued = true;
                System.out.println("Book Issued!");
                return;
            }
        }
        System.out.println("Book not available!");
    }

    static void returnBook() {
        System.out.print("Enter Book ID to Return: ");
        int id = sc.nextInt();
        for (Book b : books) {
            if (b.id == id && b.isIssued) {
                b.isIssued = false;
                System.out.println("Book Returned!");
                return;
            }
        }
        System.out.println("Invalid Book ID!");
    }

    static void viewMembers() {
        System.out.println("\n--- MEMBERS LIST ---");
        for (Member m : members) System.out.println(m);
    }
}
