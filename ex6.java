package Lab04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lab04Ex6 {

    public static void main(String[] args) throws IOException {

        ArrayList<String[]> candidates = readCandidateData("CandidatePerformanceTest.csv");

        showOverallStatistics(candidates);
        showHighAverage(candidates);
        showSubjectScores(candidates);
        showGroupStatistics(candidates);
    }

    public static ArrayList<String[]> readCandidateData(String filename) throws IOException {
        ArrayList<String[]> candidates = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        reader.readLine();
        reader.readLine();
        reader.readLine();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",", -1);
            if (data.length >= 10) {
                candidates.add(data);
            }
        }
        reader.close();
        return candidates;
    }

    public static void showOverallStatistics(ArrayList<String[]> candidates) {
        int male = 0;
        for (String[] c : candidates) {
            if (c[1].equals("male")) male++;
        }
        int total = candidates.size();
        System.out.println("Total candidates: " + total);
        System.out.printf("Male: %.2f%%, Female: %.2f%%%n",
                male * 100.0 / total, (total - male) * 100.0 / total);
    }

    public static void showHighAverage(ArrayList<String[]> candidates) {
        int count = 0, male = 0;
        for (String[] c : candidates) {
            if (Double.parseDouble(c[9]) >= 90) {
                count++;
                if (c[1].equals("male")) male++;
            }
        }
        System.out.println("\nAverage >= 90: " + count);
        System.out.printf("Male: %.2f%%, Female: %.2f%%%n",
                male * 100.0 / count, (count - male) * 100.0 / count);
    }

    public static void showSubjectScores(ArrayList<String[]> candidates) {
        int count = 0;
        for (String[] c : candidates) {
            if (Integer.parseInt(c[5]) >= 85
                    && Integer.parseInt(c[6]) >= 85
                    && Integer.parseInt(c[7]) >= 85) {
                count++;
            }
        }
        System.out.println("\nAll subjects >= 85: " + count);
    }

    public static void showGroupStatistics(ArrayList<String[]> candidates) {
        System.out.println();
        String[] groups = {"group A", "group B", "group C", "group D", "group E"};
        for (String g : groups) {
            int count = 0, male = 0;
            for (String[] c : candidates) {
                if (c[2].equals(g)) {
                    count++;
                    if (c[1].equals("male")) male++;
                }
            }
            System.out.printf("%s: %d | Male: %.2f%%, Female: %.2f%%%n",
                    g, count, male * 100.0 / count, (count - male) * 100.0 / count);
        }
    }
}

