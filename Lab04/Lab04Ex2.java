package Lab04;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Lab04Ex2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.println("Enter a number: ");
		num =sc.nextInt();
		
		File folder = new File("Ex2LuckyNumber");
		folder.mkdir();
		
		ArrayList<Integer> numbers = new ArrayList<>();
		
		try {
			Random r = new Random();
			for(int i=1; i<=num; i++) {
				File f = new File(folder, "file" +i+ ".csv");
				FileWriter fw = new FileWriter(f);
				for(int j=1; j<=100; j++) {
					int n = r.nextInt(100) + 1;
					fw.write("Lucky number: " +n+ "\n");
				}
				fw.close();
			}
			for(int i=1; i<=num; i++) {
				File f = new File(folder, "file" +i+ ".csv");
				Scanner input= new Scanner(f);
				while (input.hasNextLine()) {
					String line = input.nextLine();
					numbers.add(Integer.parseInt(line.replace("Lucky number: ", "").trim()));
				}
				input.close();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		int max = numbers.get(0);
		int min = numbers.get(0);
		for (int x : numbers) {
			if (x > max) max = x;
			if (x < min) min = x;
		}
		System.out.println("Total numbers: " + numbers.size());
		System.out.println("Max: " + max);
		System.out.println("Min: " + min);
		
		sc.close();
		
		
	}

}
