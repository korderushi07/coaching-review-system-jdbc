import java.sql.*;
import java.util.Scanner;

public class CoachingReviewSystem {

    static final String url = "jdbc:mysql://localhost:3306/coachingDB";
    static final String user = "root";
    static final String password = "root";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected Successfully!");

            while (true) {

                System.out.println("\n===== Coaching Review System =====");
                System.out.println("1 Add Review");
                System.out.println("2 View Reviews");
                System.out.println("3 Update Review");
                System.out.println("4 Delete Review");
                System.out.println("5 Search Review");
                System.out.println("6 Exit");

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Review ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Coaching Name: ");
                        String coaching = sc.nextLine();

                        System.out.print("Enter Faculty Name: ");
                        String faculty = sc.nextLine();

                        System.out.print("Enter Rating: ");
                        int rating = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Review: ");
                        String review = sc.nextLine();

                        System.out.print("Enter Student Name: ");
                        String student = sc.nextLine();

                        String insertQuery = "INSERT INTO reviews VALUES (?, ?, ?, ?, ?, ?)";

                        PreparedStatement pst = con.prepareStatement(insertQuery);

                        pst.setInt(1, id);
                        pst.setString(2, coaching);
                        pst.setString(3, faculty);
                        pst.setInt(4, rating);
                        pst.setString(5, review);
                        pst.setString(6, student);

                        pst.executeUpdate();

                        System.out.println("Review Added Successfully!");
                        break;

                    case 2:

                        Statement stmt = con.createStatement();

                        ResultSet rs = stmt.executeQuery("SELECT * FROM reviews");

                        System.out.println("ID | Coaching | Faculty | Rating | Review | Student");

                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt(1) + " | "
                                            + rs.getString(2) + " | "
                                            + rs.getString(3) + " | "
                                            + rs.getInt(4) + " | "
                                            + rs.getString(5) + " | "
                                            + rs.getString(6));
                        }

                        break;

                    case 3:

                        System.out.print("Enter Review ID to Update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Rating: ");
                        int newRating = sc.nextInt();

                        String updateQuery = "UPDATE reviews SET rating=? WHERE review_id=?";

                        PreparedStatement pst2 = con.prepareStatement(updateQuery);

                        pst2.setInt(1, newRating);
                        pst2.setInt(2, updateId);

                        pst2.executeUpdate();

                        System.out.println("Review Updated!");
                        break;

                    case 4:

                        System.out.print("Enter Review ID to Delete: ");
                        int deleteId = sc.nextInt();

                        String deleteQuery = "DELETE FROM reviews WHERE review_id=?";

                        PreparedStatement pst3 = con.prepareStatement(deleteQuery);

                        pst3.setInt(1, deleteId);

                        pst3.executeUpdate();

                        System.out.println("Review Deleted!");
                        break;

                    case 5:

                        sc.nextLine();

                        System.out.print("Enter Coaching Name: ");
                        String cname = sc.nextLine();

                        String searchQuery = "SELECT * FROM reviews WHERE coaching_name=?";

                        PreparedStatement pst4 = con.prepareStatement(searchQuery);

                        pst4.setString(1, cname);

                        ResultSet rs2 = pst4.executeQuery();

                        while (rs2.next()) {

                            System.out.println(
                                    rs2.getInt(1) + " | "
                                            + rs2.getString(2) + " | "
                                            + rs2.getString(3) + " | "
                                            + rs2.getInt(4) + " | "
                                            + rs2.getString(5) + " | "
                                            + rs2.getString(6));
                        }

                        break;

                    case 6:
                        System.out.println("Program Closed");
                        con.close();
                        return;

                    default:
                        System.out.println("Invalid Choice");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}