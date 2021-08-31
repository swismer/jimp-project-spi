package xyz.wismer.jimp.project;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import edu.umd.cs.findbugs.annotations.NonNull;
import edu.umd.cs.findbugs.annotations.Nullable;

/**
 * The API to integrate project specific functionality into Jimp.
 */
public interface Project {
	
	/**
	 * The name of this project.
	 */
	@NonNull
	String getName();
	
	/**
	 * The URL of this project's icon (preferably of size 16x16 px).
	 */
	@Nullable
	URL getIcon();
	
	/**
	 * The project IDs (first number in service IDs) used in Vertec.
	 */
	@NonNull
	Collection<String> getProjectIds();
	
	/**
	 * A collection of work package IDs common to this project. It is ensured that these packages are always known and
	 * therefore available in the lookup process.
	 */
	@NonNull
	Collection<String> getCommonWorkPackageIds();
	
	
	/**
	 * The URL of this project's templates in JSON format or <code>null</code> if there are no templates.
	 */
	@Nullable
	URL getTemplatesJson();
	
	/**
	 * The URL of this project's restrictions in JSON format or <code>null</code> if there are no restrictions.
	 */
	@Nullable
	URL getRestrictionsJson();
	
	/**
	 * Get work package suggestions based on given work entry data.
	 * 
	 * Implementations should return as quick as possible otherwise the user experience gets degraded. Lookups in
	 * external systems should not be done.
	 * 
	 * @param query the work entry to provide a suggestion for
	 */
	@NonNull
	List<WorkPackageIdSuggestion> getWorkPackageSuggestions(JimpWorkEntry query);
	
	/**
	 * Get work package suggestions based on the given queries that are very likely to be correct.
	 * 
	 * @param queries the work entries to provide a suggestion for
	 * @return a map containing a suggestion as value for those queries that are likely to be handled correctly
	 */
	@NonNull
	Map<JimpWorkEntry, WorkPackageIdSuggestion> getSafeWorkPackageSuggestions(Collection<JimpWorkEntry> queries);
}
