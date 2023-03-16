package xyz.wismer.jimp.project;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.Function;

/**
 * A template for a re-usable work entry in Jimp (e.g. for Holidays).
 */
public class JimpWorkEntryTemplate {
	/** the name of this template */
	private final String name;
	/** whether this template can be applied to a whole work week */
	private boolean allowWholeWeek = true;

	/** the default start time for the work entry (otherwise the current time is used) */
	private LocalTime defaultFrom;
	/** the duration of the work entry for the given day */
	private Function<LocalDate, Duration> durationProvider;

	private String description;
	private String workPackage;
	private boolean rejectDistribution;

	public JimpWorkEntryTemplate(String name) {
		this.name = name;
	}

	public JimpWorkEntryTemplate(String name, LocalTime defaultFrom, Function<LocalDate, Duration> durationProvider, String description, String workPackage) {
		this.name = name;
		this.defaultFrom = defaultFrom;
		this.durationProvider = durationProvider;
		this.description = description;
		this.workPackage = workPackage;
	}

	public String getName() {
		return name;
	}

	public boolean isAllowWholeWeek() {
		return allowWholeWeek;
	}

	public void setAllowWholeWeek(boolean allowWholeWeek) {
		this.allowWholeWeek = allowWholeWeek;
	}

	public LocalTime getDefaultFrom() {
		return defaultFrom;
	}

	public void setDefaultFrom(LocalTime defaultFrom) {
		this.defaultFrom = defaultFrom;
	}

	public Function<LocalDate, Duration> getDurationProvider() {
		return durationProvider;
	}

	public void setDurationProvider(Function<LocalDate, Duration> durationProvider) {
		this.durationProvider = durationProvider;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWorkPackage() {
		return workPackage;
	}

	public void setWorkPackage(String workPackage) {
		this.workPackage = workPackage;
	}

	public boolean isRejectDistribution() {
		return rejectDistribution;
	}

	public void setRejectDistribution(boolean rejectDistribution) {
		this.rejectDistribution = rejectDistribution;
	}
}
