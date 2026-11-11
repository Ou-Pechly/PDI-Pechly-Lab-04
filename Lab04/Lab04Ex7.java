package Lab04;

import java.io.*;
import java.util.ArrayList;

public class Lab04Ex7 {

    public static void main(String[] args) throws IOException {
        ArrayList<String[]> candidates = readCandidateData("CandidatePerformanceTest.csv");

        String[] groups = {"group A", "group B", "group C", "group D"};
        for (String g : groups) {
            ArrayList<String[]> list = filterByGroup(candidates, g);
            showGroupStatistics(g, list);                          
            writeGroupFile(g.replace("group ", "group") + ".csv", list);   
        }
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

    public static ArrayList<String[]> filterByGroup(ArrayList<String[]> candidates, String group) {
        ArrayList<String[]> list = new ArrayList<>();
        for (String[] c : candidates) {
            if (c[2].equals(group)) list.add(c);
        }
        return list;
    }

    public static int countMale(ArrayList<String[]> list) {
        int male = 0;
        for (String[] c : list) {
            if (c[1].equals("male")) male++;
        }
        return male;
    }

    public static void showGroupStatistics(String group, ArrayList<String[]> list) {
        int n = list.size();
        int male = countMale(list);
        System.out.printf("%s: %d students | Male: %.2f%% | Female: %.2f%%%n",
                group, n, male * 100.0 / n, (n - male) * 100.0 / n);
    }

    public static void writeGroupFile(String filename, ArrayList<String[]> list) throws IOException {
        FileWriter fw = new FileWriter(filename);
        fw.write("ID,gender,group,Education,test preparation course,Math,English,Computer,Total,Average\n");
        for (String[] c : list) {
            fw.write(String.join(",", c) + "\n");
        }

        int n = list.size();
        int male = countMale(list);
        fw.write("\nTotal students," + n + "\n");
        fw.write(String.format("%%Male,%.2f%%%n", male * 100.0 / n));
        fw.write(String.format("%%Female,%.2f%%%n", (n - male) * 100.0 / n));
        fw.close();
    }
}