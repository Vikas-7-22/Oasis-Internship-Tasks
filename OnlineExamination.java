import java.util.*;

public class OnlineExamination {
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, String> users = new HashMap<>();
    static HashMap<String, String> profiles = new HashMap<>();

    public static void main(String[] args) {
        users.put("user1", "pass1");
        profiles.put("user1", "Default Profile");

        System.out.print("Enter Username: ");
        String user = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (users.containsKey(user) && users.get(user).equals(pass)) {
            System.out.println("Login Successful!");
            examMenu(user);
        } else {
            System.out.println("Invalid Login!");
        }
    }

    static void examMenu(String user) {
        while (true) {
            System.out.println("\n--- ONLINE EXAM MENU ---");
            System.out.println("1. Update Profile & Password");
            System.out.println("2. Start Exam");
            System.out.println("3. Logout");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1: updateProfile(user); break;
                case 2: startExam(); break;
                case 3: System.out.println("Logged out!"); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    static void updateProfile(String user) {
        System.out.print("Enter new profile info: ");
        profiles.put(user, sc.nextLine());
        System.out.print("Enter new password: ");
        users.put(user, sc.nextLine());
        System.out.println("Profile & Password Updated!");
    }

    static void startExam() {
        String[] questions = {
            "Q1. Java is platform independent? (yes/no)",
            "Q2. JVM stands for? a) Java Virtual Machine b) Java Verified Mode"
        };
        String[] answers = {"yes", "a"};

        int score = 0;
        long startTime = System.currentTimeMillis();
        long duration = 30000; // 30 seconds timer

        for (int i = 0; i < questions.length; i++) {
            if (System.currentTimeMillis() - startTime > duration) {
                System.out.println("Time Up! Auto-submitted.");
                break;
            }
            System.out.println(questions[i]);
            String ans = sc.nextLine();
            if (ans.equalsIgnoreCase(answers[i])) score++;
        }
        System.out.println("Exam Over! Your Score: " + score);
    }
}
