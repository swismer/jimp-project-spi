package xyz.wismer.jimp.service.jira;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import edu.umd.cs.findbugs.annotations.CheckForNull;
import edu.umd.cs.findbugs.annotations.NonNull;

import xyz.wismer.jimp.project.Project;
import xyz.wismer.jimp.project.jira.JiraTicket;
import xyz.wismer.jimp.project.jira.JiraWorkLogEntry;

/**
 * The JIRA API for {@link Project}s. Can be injected using {@link jakarta.inject.Inject}.
 */
public interface ReadOnlyJira {
	/**
	 * Lookup a ticket in this JIRA instance.
	 *
	 * @param ticketId the JIRA ticket ID of the form (PROJECTID-1234).
	 * @param mode the JIRA access mode
	 * @return the JIRA ticket or <code>null</code> if none is available (also depending on access mode)
	 * @throws JiraException if an error occurred while accessing JIRA
	 */
	@CheckForNull
	default JiraTicket getJiraTicket(String ticketId, JiraAccessMode mode) throws JiraException {
		return getJiraTickets(List.of(ticketId), mode).stream().findFirst().orElse(null);
	}

	/**
	 * Lookup tickets in this JIRA instance.
	 *
	 * @param ticketIds the JIRA ticket IDs of the form (PROJECTID-1234).
	 * @return the available JIRA tickets (depending on access mode)
	 * @throws JiraException if an error occurred while accessing JIRA
	 */
	@NonNull
	Set<JiraTicket> getJiraTickets(Collection<String> ticketIds, JiraAccessMode mode) throws JiraException;

	/**
	 * Execute a JIRA query and return the matching tickets. Cached tickets get updated.
	 *
	 * @param jql the JIRA query
	 * @return the matching tickets
	 * @throws JiraException if an error occurred while accessing JIRA
	 */
	@NonNull
	Collection<JiraTicket> queryJiraTickets(String jql) throws JiraException;

	/**
	 * Get all cached JIRA tickets for a project.
	 *
	 * @param projectId the project of the tickets or null to get all
	 * @return a set of cached JIRA tickets
	 */
	Set<JiraTicket> getCachedJiraTickets(String projectId);

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
