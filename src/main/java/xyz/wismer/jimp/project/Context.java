package xyz.wismer.jimp.project;

import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDate;

/**
 * The context for the Jimp project API. Provides access to some services provided by the Jimp application. Can be
 * injected into {@link Project}s using {@link jakarta.inject.Inject}.
 */
public interface Context {
	/**
	 * Get the technical name of the current user (e.g. user3532).
	 */
	String getUsername();

	/**
	 * Get the duration that the user is expected to work at the given day. Is zero on weekends and holidays.
	 */
	Duration getTargetWorkingTime(LocalDate date);

	/**
	 * Get the path to the directory where the Jimp data is stored. Must not be used to access files written by Jimp,
	 * but can be used to persist project specific data.
	 */
	Path getDataDirectory();
}
