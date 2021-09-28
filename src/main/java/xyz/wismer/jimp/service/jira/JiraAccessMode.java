package xyz.wismer.jimp.service.jira;

/**
 * The JIRA access mode.
 */
public enum JiraAccessMode {
	/** use local cache only - report missing if not found locally */
	CACHE_ONLY,

	/** use local cache first and remote if not found */
	REMOTE_IF_MISSING,

	/** use remote always */
	FORCE_REMOTE
}
