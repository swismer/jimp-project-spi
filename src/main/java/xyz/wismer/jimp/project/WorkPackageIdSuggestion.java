package xyz.wismer.jimp.project;

import edu.umd.cs.findbugs.annotations.NonNull;

/**
 * A suggestion regarding a work package including a description.
 */
public class WorkPackageIdSuggestion {
	private final String workPackageId;
	private final String description;

	public WorkPackageIdSuggestion(String workPackageId, String description) {
		this.workPackageId = workPackageId;
		this.description = description;
	}

	/**
	 * Get the work package ID of this suggestion.
	 */
	@NonNull
	public String getWorkPackageId() {
		return workPackageId;
	}

	/**
	 * Get a description of this suggestion to show to the user.
	 */
	@NonNull
	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return workPackageId + "(" + description + ")";
	}
}
