package xyz.wismer.jimp.project.jira;

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
	 * The query to get all relevant tickets. Filtering by project and non-empty imputation number is done by the
	 * caller. The query is executed at least once (after the startup of Jimp).
	 */
	String getJiraQuery();
}
