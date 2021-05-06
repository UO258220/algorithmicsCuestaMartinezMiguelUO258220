package algstudent.s7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;

import algstudent.s7.util.BranchAndBound;

public class BestList extends BranchAndBound {
	
	private PrintStream out = System.out;
	
	private int n;
	private ArrayList<Song> songs;

	public static void main(String[] args) {
		try {
			String filename = args[0];
			int T = Integer.parseInt(args[1]);
			BestList bl = new BestList();
			bl.run(filename, T);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private void run(String filename, int T) {
		this.songs = new ArrayList<Song>();
		loadSongs(filename);
		
		this.rootNode = new SongListNode(T*60, T*60, new ArrayList<>(songs));
		this.branchAndBound(getRootNode());
		this.printSolutionTrace();
	}

	private void loadSongs(String filename) {

		String url = "src/algstudent/s7/" + filename;
		String[] songData = new String[3];
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(url));

			this.n = Integer.parseInt(reader.readLine()); // number of songs in the file is in the first line
			out.println(String.format("Number of songs: %d", this.n));
			out.println();
			out.println("List of songs:");

			for (int i = 0; i < n; i++) {
				String line = reader.readLine();
				songData = line.split("\t");
				songs.add(new Song(songData[0], computeSeconds(songData[1]), Integer.parseInt(songData[2])));
				out.println(String.format("id: %s seconds: %s score: %s", songData[0], songData[1], songData[2]));
			}
			out.println();
			reader.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private int computeSeconds(String time) throws Exception {
		String[] parts = time.split(":");
		int minutes = Integer.parseInt(parts[0]);
		int seconds = Integer.parseInt(parts[1]);
		return minutes * 60 + seconds;
	}

}
