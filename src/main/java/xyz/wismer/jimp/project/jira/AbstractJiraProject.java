package xyz.wismer.jimp.project.jira;

import jakarta.inject.Inject;
import xyz.wismer.jimp.project.Context;
import xyz.wismer.jimp.project.JimpWorkEntry;
import xyz.wismer.jimp.service.jira.JiraAccessMode;
import xyz.wismer.jimp.service.jira.JiraException;
import xyz.wismer.jimp.service.jira.ReadOnlyJira;

import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

/**
 * An abstract base class for JIRA projects.
 */
public abstract class AbstractJiraProject implements JiraProject {
    @Inject
    protected Context context;
    @Inject
    protected ReadOnlyJira jira;

    private final Pattern ticketPattern;

    protected AbstractJiraProject() {
        ticketPattern = Pattern.compile(getJiraIdentifier() + "-\\d+");
    }

    @Override
    public Collection<JiraTicket> getAllJiraTickets(JiraAccessMode mode) {
        if (mode == JiraAccessMode.CACHE_ONLY) {
            return jira.getCachedJiraTickets(getJiraIdentifier());
        } else {
            String query = "project=" + getJiraIdentifier() + " AND (" + getJiraQuery() + ")";
            try {
                return jira.queryJiraTickets(query);
            } catch (JiraException e) {
                return List.of();
            }
        }
    }

    /**
     * The query to get all relevant tickets.
     */
    protected abstract String getJiraQuery();

    @Override
    public JiraTicketLookupResult getJiraTicket(JimpWorkEntry workEntry, JiraAccessMode mode) {
        String ticketId = workEntry.getTicketId();
        if (ticketId != null && ticketPattern.matcher(ticketId).matches()) {
            JiraTicket ticket;
            try {
                ticket = jira.getJiraTicket(ticketId, mode);
            } catch (JiraException e) {
                return JiraTicketLookupResult.ofError("Could not load JIRA tickets");
            }
            if (ticket != null) {
                return validateTicket(workEntry, ticket);
            }
        }
        return JiraTicketLookupResult.ofNoResult();
    }

    protected JiraTicketLookupResult validateTicket(JimpWorkEntry workEntry, JiraTicket ticket) {
        // default implementation: accept ticket, but do not use time tracking
        return JiraTicketLookupResult.ofTicket(ticket, false);
    }
}
