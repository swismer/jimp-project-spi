package xyz.wismer.jimp.project;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import edu.umd.cs.findbugs.annotations.NonNull;
import edu.umd.cs.findbugs.annotations.Nullable;

/**
 * The API to integrate project specific functionality into Jimp. Implementations get discovered using Java's
 * {@link java.util.ServiceLoader} mechanism (i.e. they must be registered in META-INF/services/xyz.wismer.jimp.project.Project)
 */
public interface Project {

	int SPI_MAJOR_VERSION = 1;
	int SPI_MINOR_VERSION = 0;
	
	/**
	 * The name of this project.
	 */
	@NonNull
	String getName();
	
	/**
	 * The input stream to get this project's icon (preferably of size 16x16 px).
	 */
	@Nullable
	InputStream getIcon();
	
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
	 * The input stream to get this project's templates in JSON format or <code>null</code> if there are none.
	 */
	@Nullable
	InputStream getTemplatesJson();
	
	/**
	 * The input stream to get this project's restrictions in JSON format or <code>null</code> if there are none.
	 */
	@Nullable
	InputStream getRestrictionsJson();
	
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
