package Lab04;

import java.io.*;
import java.util.*;

public class Lab04Ex5 {
    public static void main(String[] args) throws IOException {
        String file = "Ex3StudentData.csv";
        ArrayList<String> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new FileReader(file));
        String header = br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                students.add(line);
            }
        }
        br.close();

        for (int i = 1; i <= 3; i++) {
            System.out.print("Name: ");
            String name = input.nextLine();
            System.out.print("ID: ");
            String id = input.nextLine();
            System.out.print("Gender: ");
            String gender = input.nextLine();
            students.add(name + "," + id + "," + gender);
        }
        input.close();

        students.sort(String.CASE_INSENSITIVE_ORDER);

        FileWriter fw = new FileWriter(file);
        fw.write(header + "\n");
        for (String s : students) {
            fw.write(s + "\n");
        }
        fw.close();
    }
}