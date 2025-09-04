import java.util.*;

class Reservation {
    String pnr, name, trainNo, trainName, from, to, date, classType;
    public Reservation(String pnr, String name, String trainNo, String trainName, String from, String to, String date, String classType) {
        this.pnr = pnr;
        this.name = name;
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.from = from;
        this.to = to;
        this.date = date;
        this.classType = classType;
    }
    public String toString() {
        return "PNR: " + pnr + ", Name: " + name + ", Train: " + trainNo + "-" + trainName +
               ", From: " + from + " To: " + to + ", Date: " + date + ", Class: " + classType;
    }
}

public class OnlineReservationSystem {
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, Reservation> reservations = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- ONLINE RESERVATION SYSTEM ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1: bookTicket(); break;
                case 2: cancelTicket(); break;
                case 3: viewReservation(); break;
                case 4: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }

    static void bookTicket() {
        System.out.print("Enter PNR: "); String pnr = sc.nextLine();
        System.out.print("Enter Passenger Name: "); String name = sc.nextLine();
        System.out.print("Enter Train No: "); String trainNo = sc.nextLine();
        System.out.print("Enter Train Name: "); String trainName = sc.nextLine();
        System.out.print("Enter From: "); String from = sc.nextLine();
        System.out.print("Enter To: "); String to = sc.nextLine();
        System.out.print("Enter Date (dd-mm-yyyy): "); String date = sc.nextLine();
        System.out.print("Enter Class Type: "); String classType = sc.nextLine();

        reservations.put(pnr, new Reservation(pnr, name, trainNo, trainName, from, to, date, classType));
        System.out.println("Ticket booked successfully!");
    }

    static void cancelTicket() {
        System.out.print("Enter PNR to Cancel: ");
        String pnr = sc.nextLine();
        if (reservations.containsKey(pnr)) {
            reservations.remove(pnr);
            System.out.println("Ticket cancelled successfully!");
        } else {
            System.out.println("PNR not found!");
        }
    }

    static void viewReservation() {
        System.out.print("Enter PNR to View: ");
        String pnr = sc.nextLine();
        if (reservations.containsKey(pnr)) {
            System.out.println(reservations.get(pnr));
        } else {
            System.out.println("PNR not found!");
        }
    }
}
