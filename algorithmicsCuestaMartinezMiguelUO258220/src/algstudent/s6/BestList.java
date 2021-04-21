package algstudent.s6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class BestList {

	private static PrintStream out = System.out;

	public int n;
	public int maxLen;
	public List<Song> songs;

	private int counter;
	private int score = 0;
	private List<Song> blockA;
	private List<Song> blockB;
	private int lenA;
	private int lenB;

	private int bestScore;
	private List<Song> bestA;
	private List<Song> bestB;

	public static void main(String[] args) {

		try {
			String filename = args[0];
			int n = Integer.parseInt(args[1]);
			BestList bl = new BestList();
			bl.run(filename, n);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public void run(String filename, int n) {
		this.maxLen = n * 60;
		this.songs = new LinkedList<Song>();

		this.counter = 0;
		this.score = 0;
		this.blockA = new LinkedList<Song>();
		this.blockB = new LinkedList<Song>();
		this.lenA = 0;
		this.lenB = 0;
		this.bestScore = 0;
		this.bestA = new LinkedList<Song>();
		this.bestB = new LinkedList<Song>();

		loadSongs(filename);
		backtracking(0);

		printSolution();
	}

	private void loadSongs(String filename) {

		String url = "src/algstudent/s6/" + filename;
		String line = "";
		String[] songData = new String[3];
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(url));

			this.n = Integer.parseInt(reader.readLine()); // number of songs in the file is in the first line
			out.println(String.format("Number of songs: %d", n));
			out.println();
			out.println("List of songs:");

			for (int i = 0; i < n; i++) {
				line = reader.readLine();
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

	/*
	 * Complexity is 3 to the n, as it enters three new states in each level of the
	 * search tree for each branch
	 */
	public void backtracking(int level) {

		if (level != 0) {
			counter++;
			if (score > bestScore) {
				bestScore = score;
				bestA = new LinkedList<>(blockA);
				bestB = new LinkedList<>(blockB);
			}
			if (level >= n)
				return;
		}

		Song song = songs.get(level);
		int seconds = song.getSeconds();
		int songScore = song.getScore();

		// Put in block A (if possible)
		if (maxLen - lenA >= seconds) {
			lenA += seconds;
			score += songScore;
			blockA.add(song);
			backtracking(level + 1);
			lenA -= seconds;
			score -= songScore;
			blockA.remove(song);
		}

		// Put in block B (if possible)
		if (maxLen - lenB >= seconds) {
			lenB += seconds;
			score += songScore;
			blockB.add(song);
			backtracking(level + 1);
			lenB -= seconds;
			score -= songScore;
			blockB.remove(song);
		}

		// Don't add the song
		backtracking(level + 1);
	}

	private void printSolution() {

		if (bestScore == 0) {
			out.println("NO SOLUTION FOUND");
			return;
		}

		out.println(String.format("Length of the blocks: %d:0", maxLen / 60));
		out.println(String.format("Total score: %d", bestScore));
		out.println(String.format("Total counter: %d", counter));
		out.println();

		out.println("Best block A:");
		for (Song song : bestA) {
			out.println(String.format("id: %s seconds: %d:%d score: %d", song.getId(), song.getSeconds() / 60,
					song.getSeconds() % 60, song.getScore()));
		}
		out.println();

		out.println("Best block B:");
		for (Song song : bestB) {
			out.println(String.format("id: %s seconds: %d:%d score: %d", song.getId(), song.getSeconds() / 60,
					song.getSeconds() % 60, song.getScore()));
		}
	}

	public class Song {

		private String id;
		private int seconds;
		private int score;

		public Song(String id, int seconds, int score) {
			this.setId(id);
			this.setSeconds(seconds);
			this.setScore(score);
		}

		private void setId(String id) {
			this.id = id;
		}

		private void setSeconds(int seconds) {
			this.seconds = seconds;
		}

		private void setScore(int score) {
			this.score = score;
		}

		public String getId() {
			return id;
		}

		public int getSeconds() {
			return seconds;
		}

		public int getScore() {
			return score;
		}

	}

}
