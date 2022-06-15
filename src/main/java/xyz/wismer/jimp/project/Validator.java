package xyz.wismer.jimp.project;

public interface Validator {
	/**
	 * Get the validation error message for the aggregated work entries or null if they are valid.
	 */
	String validate(WorkStatistics workStatistics);
}
