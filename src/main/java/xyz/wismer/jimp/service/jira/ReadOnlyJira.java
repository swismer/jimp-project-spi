package xyz.wismer.jimp.service.jira;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import edu.umd.cs.findbugs.annotations.CheckForNull;
import edu.umd.cs.findbugs.annotations.NonNull;

import xyz.wismer.jimp.project.Project;
import xyz.wismer.jimp.project.jira.JiraProject;
import xyz.wismer.jimp.project.jira.JiraTicket;
import xyz.wismer.jimp.project.jira.JiraWorkLogEntry;

/**
 * The JIRA API for {@link Project}s. Can be injected using {@link jakarta.inject.Inject}.
 */
public interface ReadOnlyJira {
	/**
	 * Lookup a ticket in the project's JIRA. There is no JIRA access inside this method call, but only the results
	 * previously fetched using the provided query in {@link JiraProject#getJiraQuery()} are available.
	 *
	 * @param ticketId the JIRA ticket ID of the form (PROJECTID-1234).
	 * @return the JIRA ticket or <code>null</code> if none is available
	 */
	@CheckForNull
	JiraTicket getJiraTicket(String ticketId);

	/**
	 * Lookup tickets in the project's JIRA. Cached tickets get updated.
	 * 
	 * @param ticketIds the JIRA ticket IDs of the form (PROJECTID-1234).
	 * @return a map containing the lookup result for each requested ticket (might contain <code>null</code> if no
	 *         ticket is available)
	 * @throws JiraException if an error occurred while accessing JIRA
	 */
	@NonNull
	Map<String, JiraTicket> loadJiraTickets(Collection<String> ticketIds) throws JiraException;

	/**
	 * Get the work log entries for the given JIRA ticket.
	 * 
	 * @param ticketId the JIRA ticket ID
	 * @return the work log entries
	 * @throws JiraException if an error occurred while accessing JIRA
	 */
	@NonNull
	List<JiraWorkLogEntry> getJiraWorkLogEntries(String ticketId) throws JiraException;
}
