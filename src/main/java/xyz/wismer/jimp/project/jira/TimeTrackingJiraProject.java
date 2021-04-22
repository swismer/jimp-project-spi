package xyz.wismer.jimp.project.jira;

import xyz.wismer.jimp.project.JimpWorkEntry;

/**
 * An extended project interface for projects backed by JIRA using time tracking.
 */
public interface TimeTrackingJiraProject extends JiraProject {
	/**
	 * Get the JIRA ticket for time tracking matching to the query.
	 * 
	 * @param query the work package query
	 * @return the result of the lookup
	 */
	JiraTicketLookupResult getWorkLogTicket(JimpWorkEntry query);
}
