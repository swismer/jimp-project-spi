package xyz.wismer.jimp.project;

import edu.umd.cs.findbugs.annotations.CheckForNull;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * The API to integrate project specific functionality into Jimp.
 */
public interface Project {
	
	/**
	 * The name of this project.
	 */
	String getName();
	
	/**
	 * The URL of this project's icon (preferably of size 16x16 px).
	 */
	URL getIcon();
	
	/**
	 * The project IDs (first number in service IDs) used in Vertec.
	 */
	Collection<String> getProjectIds();
	
	/**
	 * A collection of work package IDs common to this project. It is ensured that these packages are always known and
	 * therefore available in the lookup process.
	 */
	Collection<String> getCommonWorkPackageIds();
	
	
	/**
	 * The URL of this project's templates in JSON format or <code>null</code> if there are no templates.
	 */
	@CheckForNull
	URL getTemplatesJson();
	
	/**
	 * The URL of this project's restrictions in JSON format or <code>null</code> if there are no templates.
	 */
	@CheckForNull
	URL getRestrictionsJson();
	
	
	/**
	 * Get work package suggestions based on given service description and date.
	 * 
	 * Implementations should return as quick as possible otherwise the user experience gets degraded. Lookups in
	 * external systems should be postponed using the aforementioned references.
	 * 
	 * @param query the work entry to provide a suggestion for
	 */
	List<WorkPackageIdSuggestion> getSuggestions(JimpWorkEntry query);
	
	/**
	 * Get work package suggestions based on the given queries that are very likely to be correct.
	 * 
	 * @param queries the work entries to provide a suggestion for
	 * @return a map containing a suggestion as value for those queries that are likely to be handled correctly
	 */
	Map<JimpWorkEntry, WorkPackageIdSuggestion> getSafeSuggestions(Collection<JimpWorkEntry> queries);
	
}
