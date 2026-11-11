package Lab04;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lab04Ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try (FileWriter fw = new FileWriter("Ex3StudentData.csv")) {
            fw.write("Name,ID,Gender\n");

            for (int i = 1; i <= 3; i++) {
                System.out.println("Student " + i);
                System.out.print("Name: ");
                String name = input.nextLine();
                System.out.print("ID: ");
                String id = input.nextLine();
                System.out.print("Gender: ");
                String gender = input.nextLine();

                fw.write(name + "," + id + "," + gender + "\n");
            }
            System.out.println("Data saved to Ex3StudentData.csv");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        input.close();
    }
}