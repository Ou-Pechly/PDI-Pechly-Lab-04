package Lab04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lab04Ex4 {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("Ex3StudentData.csv"))) {
            br.readLine(); 
            String line;
            while ((line = br.readLine()) != null) {
                students.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        for (String s : students) {
            System.out.println(s);
        }
    }
}