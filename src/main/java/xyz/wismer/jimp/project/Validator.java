package xyz.wismer.jimp.project;

import java.time.Duration;
import java.util.Map;

public interface Validator {
	enum TimeRange {DAY, MONTH}

	/**
	 * Get the time range on which this validator performs its checks
	 */
	TimeRange getTimeRange();

	/**
	 * Get the validation error message for the aggregated work entries (in the time range defined by
	 * {@link #getTimeRange()}) or null if they are valid.
	 */
	String validate(Map<String, Duration> durations);
}
