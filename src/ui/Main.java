package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	
	private static BufferedReader br;
	private static BufferedWriter bw;
	
	private static int cases = 0;
	private static int from[] = {0};   //a toma valor abajo
	private static int middle[] = {0};
	private static int to[] = {0};

	public Main() throws IOException {
		System.out.println(" | ===================================== | \n"
				+ " | ====  Welcome to Towers of Hanoi  === | \n"
				+ " | ===================================== | ");
		
		br = new BufferedReader(new FileReader("data/input.txt"));
		bw = new BufferedWriter(new FileWriter("data/output.txt"));
	}

	public static void main(String[] juank) {
		try {
			Main main = new Main();
			
			String line = br.readLine();
			main.repeater(line);
			
			br.close();
			bw.close();
			System.out.println(" | Was export " + cases + " cases in output.txt      | ");
			
		} catch (IOException e) {
			System.out.println(" | Cannot read a Line");
		} catch (NumberFormatException e) {
			System.out.println(" | The value should be a number");
		}
	}
	
	public void repeater(String line) throws NumberFormatException, IOException {
		if(line != null) {
			int c = Integer.parseInt(line);
			cases += c;
			startGame(c);
			
			line = br.readLine();
			line = br.readLine();
			repeater(line);
		}
	}
	
	public void startGame(int f) throws NumberFormatException, IOException {
		if(f > 0) {
			int d = Integer.parseInt(br.readLine());
			from[0] = d;
			bw.write(from[0] + " " + middle[0] + " " + to[0] + "\n");
			towersOfHanoi(d, from, middle, to);
			bw.write("\n");
			from[0] = 0;
			middle[0] = 0;
			to[0] = 0;
			startGame(f-1);
		}
	}
	
	//from == origen
	// middle = aux
	//to = destino
	public void towersOfHanoi(int d, int[]f, int[]m, int[]t) throws IOException{
		if(d == 1) {
			f[0]--;
			t[0]++;
			bw.write(from[0] + " " + middle[0] + " " + to[0] + "\n");
		} else {
			towersOfHanoi(d-1, f, t, m);
			f[0]--;
			t[0]++;
			bw.write(from[0] + " " + middle[0] + " " + to[0] + "\n");
			towersOfHanoi(d-1, m, f, t);
		}
	}
	
}
