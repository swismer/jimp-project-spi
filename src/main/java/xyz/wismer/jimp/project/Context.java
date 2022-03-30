package xyz.wismer.jimp.project;

import java.nio.file.Path;
import java.time.Duration;

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
	 * Get the duration that the user is expected to work at one day, e.g. 8h
	 */
	default Duration getDailyWorkLoad() {
		return Duration.ofMinutes(8 * 60 + 12);
	}
	
	/**
	 * Get the path to the directory where the Jimp data is stored. Must not be used to access files written by Jimp,
	 * but can be used to persist project specific data.
	 */
	Path getDataDirectory();
}
