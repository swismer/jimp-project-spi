package xyz.wismer.jimp.project.jira;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * An entry in the JIRA work log.
 */
public class JiraWorkLogEntry {
	private long id;
	private LocalDateTime date;
	private String author;
	private String comment;
	private Duration duration;

	/**
	 * Create a new work log entry that has not yet been stored in JIRA.
	 */
	public JiraWorkLogEntry(LocalDateTime date, String comment, Duration duration) {
		this(-1, date, null, comment, duration);
	}

	/**
	 * Create a work log entry that has been stored in JIRA.
	 */
	public JiraWorkLogEntry(long id, LocalDateTime date, String author, String comment, Duration duration) {
		this.id = id;
		this.date = date;
		this.author = author;
		this.comment = comment;
		this.duration = duration;
	}

	/**
	 * Get the JIRA's internal ID for this work log entry.
	 */
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Get the date and time when this entry has been created or updated.
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * Get the author of this log entry as technical user (e.g. user3532)
	 */
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Get the comment for this work log entry
	 */
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Get the logged duration for this entry.
	 */
	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "JiraWorkLogEntry{" +
				"duration=" + duration +
				'}';
	}
}
