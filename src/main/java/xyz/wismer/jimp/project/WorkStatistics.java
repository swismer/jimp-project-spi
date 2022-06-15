package xyz.wismer.jimp.project;

import edu.umd.cs.findbugs.annotations.NonNull;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Map;

/**
 * The user's work statistics (can be accessed by {@link Validator}s).
 */
public interface WorkStatistics {
    /**
     * Get the total work duration in the current month that the user has assigned to work packages starting with the
     * given prefix.
     *
     * @param prefix the work package prefix (can be an empty string to select all)
     * @return the total work duration
     */
    @NonNull
    Duration getTotalDuration(String prefix);

    /**
     * Get the work duration for all days in the current month that the user has assigned to work packages starting with
     * the given prefix.
     *
     * @param prefix the work package prefix (can be an empty string to select all)
     * @return the total work duration by day
     */
    @NonNull
    Map<LocalDate, Duration> getDurations(String prefix);
}
