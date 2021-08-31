package xyz.wismer.jimp.project.jira;

import xyz.wismer.jimp.project.JimpWorkEntry;
import xyz.wismer.jimp.project.Project;

/**
 * An extended project interface for projects backed by JIRA.
 */
public interface JiraProject extends Project {
	/**
	 * The project identifier in JIRA (uppercase letters without spaces).
	 */
	String getJiraIdentifier();
	
	/**
	 * The query to get all relevant tickets. Filtering by project is done by the
	 * caller. The query is executed at least once (after the startup of Jimp).
	 */
	String getJiraQuery();

	/**
	 * Find the JIRA ticket matching to the query.
	 *
	 * @param query the work package query
	 * @return the result of the lookup
	 */
	JiraTicketLookupResult findJiraTicket(JimpWorkEntry query);
}
