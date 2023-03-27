package xyz.wismer.jimp.project.jira;

import java.time.Duration;
import java.util.List;

/**
 * A JIRA ticket. Only the most important fields are available.
 */
public class JiraTicket {
	private final String id;
	private final String type;
	private final String title;
	private final String workPackage;
	private final String feature;
	private final List<String> components;

	private String assignee;
	private Duration timeSpent;
	private Duration timeEstimate;

	public JiraTicket(String id, String type, String title) {
		this(id, type, title, null, null, List.of());
	}

	public JiraTicket(String id, String type, String title, String workPackage, String feature) {
		this(id, type, title, workPackage, feature, List.of());
	}

	public JiraTicket(String id, String type, String title, String workPackage, String feature, List<String> components) {
		this.id = id;
		this.type = type;
		this.title = title;
		this.workPackage = workPackage;
		this.feature = feature;
		this.components = components;
	}

	/**
	 * Get the ticket ID (like PROJECTID-1234).
	 */
	public String getId() {
		return id;
	}

	/**
	 * Get the ticket type (e.g. Bug or Task)
	 */
	public String getType() {
		return type;
	}

	/**
	 * Get the title of this ticket.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Get the work package to be used when working on this ticket or null if none is set.
	 */
	public String getWorkPackage() {
		return workPackage;
	}

	/**
	 * Get feature ticket or null if none is set.
	 */
	public String getFeature() {
		return feature;
	}

	/**
	 * Get the assigned components of this ticket.
	 */
	public List<String> getComponents() {
		return components;
	}

	/**
	 * Get the assignee as technical user name (e.g. user3532)
	 */
	public String getAssignee() {
		return assignee;
	}

	/**
	 * Set the assignee as technical user name (e.g. user3532)
	 * @param assignee the assignee as technical user name
	 */
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	/**
	 * Get the total time spent on this ticket (by any user).
	 */
	public Duration getTimeSpent() {
		return timeSpent;
	}

	/**
	 * Set the total time spent on this ticket (by any user).
	 * @param timeSpent the total time spent
	 */
	public void setTimeSpent(Duration timeSpent) {
		this.timeSpent = timeSpent;
	}

	/**
	 * Get the estimated time to complete this ticket.
	 */
	public Duration getTimeEstimate() {
		return timeEstimate;
	}

	/**
	 * Set the estimated time to complete this ticket.
	 * @param timeEstimate the estimated time
	 */
	public void setTimeEstimate(Duration timeEstimate) {
		this.timeEstimate = timeEstimate;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof JiraTicket) {
			JiraTicket other = (JiraTicket)obj;
			return id.equals(other.id);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(id);
		sb.append(" (").append(type).append("): ").append(title);
		if (workPackage != null && !workPackage.isEmpty()) {
			sb.append(" [").append(workPackage).append("]");
		}
		return sb.toString();
	}
}
