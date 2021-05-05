package algstudent.s7;

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