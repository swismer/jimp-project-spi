package xyz.wismer.jimp.project.jira;

import edu.umd.cs.findbugs.annotations.NonNull;
import xyz.wismer.jimp.project.JimpWorkEntry;
import xyz.wismer.jimp.project.Project;
import xyz.wismer.jimp.service.jira.JiraAccessMode;

import java.util.Collection;

/**
 * An extended project interface for projects backed by JIRA.
 */
public interface JiraProject extends Project {
	/**
	 * The project identifier in JIRA (uppercase letters without spaces).
	 */
	@NonNull
	String getJiraIdentifier();

	/**
	 * Get all relevant tickets of this project. Used to provide search functionality.
	 *
	 * @param mode the JIRA access mode
	 * @return the relevant tickets
	 */
	@NonNull
	Collection<JiraTicket> getAllJiraTickets(JiraAccessMode mode);

	/**
	 * Get the JIRA ticket for a given work entry.
	 *
	 * @param workEntry the work entry
	 * @param mode the JIRA access mode
	 * @return the result of the lookup
	 */
	@NonNull
	JiraTicketLookupResult getJiraTicket(JimpWorkEntry workEntry, JiraAccessMode mode);
}
