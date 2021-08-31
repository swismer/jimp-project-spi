package xyz.wismer.jimp.project.jira;

import edu.umd.cs.findbugs.annotations.CheckForNull;

/**
 * The result of a JIRA lookup. Is either providing a {@link JiraTicket}, no result or an error message.
 */
public class JiraTicketLookupResult {
	private final JiraTicket ticket;
	private final boolean useTimeTracking;
	private final String errorMessage;
	
	private JiraTicketLookupResult(JiraTicket ticket, boolean useTimeTracking, String errorMessage) {
		this.ticket = ticket;
		this.useTimeTracking = useTimeTracking;
		this.errorMessage = errorMessage;
	}
	
	public static JiraTicketLookupResult ofTicket(JiraTicket ticket, boolean useTimeTracking) {
		return new JiraTicketLookupResult(ticket, useTimeTracking, null);
	}
	
	public static JiraTicketLookupResult ofNoResult() {
		return new JiraTicketLookupResult(null, false, null);
	}
	
	public static JiraTicketLookupResult ofError(String errorMessage) {
		return new JiraTicketLookupResult(null, false, errorMessage);
	}

	/**
	 * Get the ticket found or null if none could be found
	 */
	@CheckForNull
	public JiraTicket getTicket() {
		return ticket;
	}

	/**
	 * Whether to use time tracking or not.
	 */
	public boolean isUseTimeTracking() {
		return useTimeTracking;
	}

	/**
	 * Get the error message in case the lookup failed.
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	
	@Override
	public String toString() {
		if (ticket != null) {
			return ticket.getId();
		} else {
			return errorMessage;
		}
	}
}
