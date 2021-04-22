package xyz.wismer.jimp.service.jira;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import xyz.wismer.jimp.project.Project;
import xyz.wismer.jimp.project.jira.JiraProject;
import xyz.wismer.jimp.project.jira.JiraTicket;
import xyz.wismer.jimp.project.jira.JiraWorkLogEntry;
import edu.umd.cs.findbugs.annotations.CheckForNull;

/**
 * The JIRA API for Jimp. Can be injected into {@link Project}s using {@link jakarta.inject.Inject}.
 */
public interface Jira {
	/**
	 * Lookup tickets of the given project specified by {@link JiraProject#getJiraQuery()}.
	 *
	 * @throws JiraException if an error occurred while accessing JIRA
	 */
	void loadProjectJiraTickets(JiraProject project) throws JiraException;
	
	/**
	 * Lookup tickets in the project's JIRA. Cached tickets get updated.
	 * 
	 * @param ticketIds the JIRA ticket IDs of the form (PROJECTID-1234).
	 * @return a map containing the lookup result for each requested ticket (might contain <code>null</code> if no
	 *         ticket is available)
	 * @throws JiraException if an error occurred while accessing JIRA
	 */
	Map<String, JiraTicket> loadJiraTickets(Collection<String> ticketIds) throws JiraException;

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
	 * Checks if there is time tracking activated for any ticket using the given work package id. There is no JIRA
	 * access inside this method call, but only the results previously fetched using the provided query in
	 * {@link JiraProject#getJiraQuery()} are available.
	 * 
	 * @param workPackageId the work package id
	 * @return <code>true</code> if there is at least one ticket using the given work package id and having time
	 *         tracking activated
	 */
	boolean hasTimeTracking(String workPackageId);


	/**
	 * Get the work log entries for the given JIRA ticket.
	 * 
	 * @param ticketId the JIRA ticket ID
	 * @return the work log entries
	 * @throws JiraException if an error occurred while accessing JIRA
	 */
	List<JiraWorkLogEntry> getJiraWorkLogEntries(String ticketId) throws JiraException;

	/**
	 * Save or update the work log entries for the given JIRA ticket.
	 * @param ticketId the JIRA ticket ID
	 * @param entry the work log entry to be saved (added or updated)
	 * @throws JiraException if an error occurred while accessing JIRA
	 */
	void saveJiraWorkLogEntry(String ticketId, JiraWorkLogEntry entry) throws JiraException;
}
