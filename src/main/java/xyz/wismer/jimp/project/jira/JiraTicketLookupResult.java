package xyz.wismer.jimp.project.jira;

import edu.umd.cs.findbugs.annotations.CheckForNull;

/**
 * The result of a JIRA lookup. Is either providing a {@link JiraTicket}, no result or an error message.
 */
public class JiraTicketLookupResult {
	private final JiraTicket ticket;
	private final String errorMessage;
	
	private JiraTicketLookupResult(JiraTicket ticket, String errorMessage) {
		this.ticket = ticket;
		this.errorMessage = errorMessage;
	}
	
	public static JiraTicketLookupResult ofTicket(JiraTicket ticket) {
		return new JiraTicketLookupResult(ticket, null);
	}
	
	public static JiraTicketLookupResult ofNoResult() {
		return new JiraTicketLookupResult(null, null);
	}
	
	public static JiraTicketLookupResult ofError(String errorMessage) {
		return new JiraTicketLookupResult(null, errorMessage);
	}

	/**
	 * Get the ticket found or null if none could be found
	 */
	@CheckForNull
	public JiraTicket getTicket() {
		return ticket;
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
