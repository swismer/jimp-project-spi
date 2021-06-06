package xyz.wismer.jimp.project;

import java.time.LocalDate;

/**
 * The work entry data that a Jimp user entered.
 */
public class JimpWorkEntry {
	private final LocalDate date;
	private final String ticketId;
	private final String description;
	private final String workPackage;
	
	
	public JimpWorkEntry(LocalDate date, String ticketId, String description, String workPackage) {
		this.date = date;
		this.ticketId = ticketId;
		this.description = description;
		this.workPackage = workPackage;
	}

	/**
	 * Get the data of the work entry.
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Get the ticket ID of this work entry.
	 */
	public String getTicketId() {
		return ticketId;
	}

	/**
	 * Get the description that the Jimp user provided for this entry
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Get the current work package that the Jimp user selected.
	 */
	public String getWorkPackage() {
		return workPackage;
	}
	
	@Override
	public String toString() {
		return (ticketId != null ? ticketId + ": " : "") + description + "/" + workPackage + "@" + date;
	}
}
