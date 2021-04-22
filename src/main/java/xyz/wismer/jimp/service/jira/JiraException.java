package xyz.wismer.jimp.service.jira;

/**
 * An exception that happened during access to JIRA.
 */
public class JiraException extends Exception {
	public JiraException(String message, Throwable cause) {
		super(message, cause);
	}
}
