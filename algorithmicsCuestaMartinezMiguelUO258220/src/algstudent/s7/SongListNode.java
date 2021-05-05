package algstudent.s7;

import java.util.ArrayList;
import java.util.UUID;

import algstudent.s7.util.Node;

public class SongListNode extends Node {
	
	private int timeLimit;
	private Song currentSong;

	public SongListNode(int depth, UUID parentID) {
		super();
		this.depth = depth;
		this.parentID = parentID;
	}

	public SongListNode(int depth, UUID parentID, Song song) {
		super();
		this.depth = depth;
		this.parentID = parentID;
		this.currentSong = song;
	}
	
	@Override
	public int initialValuePruneLimit() {
		return this.timeLimit;
	}
	
	public void setTimeLimit(int seconds) {
		this.timeLimit = seconds;
	}

	@Override
	public void calculateHeuristicValue() {
		
		return;
	}

	@Override
	public ArrayList<Node> expand() {
		ArrayList<Node> children = new ArrayList<>();
		
		// First child is no song added
		children.add(new SongListNode(getDepth() + 1, getID()));
		
		
		
		return children;
	}

	@Override
	public boolean isSolution() {
		
		return false;
	}

}
