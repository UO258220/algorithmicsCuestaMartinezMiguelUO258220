package algstudent.s7;

import java.util.ArrayList;
import java.util.UUID;

import algstudent.s7.util.Node;

public class SongListNode extends Node {

	private static final int ADD_SONG_A = 0;
	private static final int ADD_SONG_B = 1;
	private static final int ADD_SONG_NONE = 2;

	private int remainingTimeA;
	private int remainingTimeB;
	private ArrayList<Song> songs;
	private Song currentSong;

	public SongListNode(int remainingTimeA, int remainingTimeB, ArrayList<Song> songs) {
		super();
		this.remainingTimeA = remainingTimeA;
		this.remainingTimeB = remainingTimeB;
		this.songs = songs;

		calculateHeuristicValue();
	}

	public SongListNode(int remainingTimeA, int remainingTimeB, ArrayList<Song> songs, int depth, UUID parentID,
			int state) {
		this(remainingTimeA, remainingTimeB, songs);
		this.depth = depth;
		this.parentID = parentID;
		this.currentSong = songs.remove(0);

		insertSong(state);
		calculateHeuristicValue();
	}

	private void insertSong(int state) {
		if (songs.isEmpty()) {
			return;
		}
		switch (state) {
		case ADD_SONG_A: {
			this.remainingTimeA -= currentSong.getSeconds();
			break;
		}
		case ADD_SONG_B: {
			this.remainingTimeB -= currentSong.getSeconds();
			break;
		}
		case ADD_SONG_NONE: {
			this.currentSong = null;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value for state: " + state);
		}
	}

	@Override
	public void calculateHeuristicValue() {
		this.heuristicValue = (this.currentSong == null) ? 0 : -this.currentSong.getScore();
	}

	@Override
	public ArrayList<Node> expand() {

		depth++;
		ArrayList<Node> children = new ArrayList<>();

		for (int state = 0; state < 3; state++) {
			children.add(new SongListNode(remainingTimeA, remainingTimeB, new ArrayList<>(songs), getDepth(), getID(),
					state));
		}

		return children;
	}

	@Override
	public boolean isSolution() {
		int smallestTime = songs.stream().map(s -> s.getSeconds()).min((a, b) -> a - b).get();
		return this.remainingTimeA < smallestTime && this.remainingTimeB < smallestTime;
	}

	@Override
	public String toString() {
		return "ID:" + getID() + " - Heuristic of the state: " + getHeuristicValue();
	}

}
