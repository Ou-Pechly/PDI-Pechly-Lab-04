package Lab04;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Lab04Ex1 {

	public static void main(String[] args) {
		
		
		File f = new File("LuckyNumber.csv");
		
		try {
			FileWriter fw = new FileWriter(f);
			Random r = new Random();
			for(int i=1; i<=500; i++) {
				int n = r.nextInt(1000);
				fw.write("Lucky number: " +n+ "\n");
			}
			fw.close();
		
		}catch (IOException e) {
			System.out.println("Error!");
		}

	}
}	
