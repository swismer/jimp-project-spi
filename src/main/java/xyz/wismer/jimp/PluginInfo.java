package xyz.wismer.jimp;

import java.io.File;
import java.net.URL;
import java.util.Collection;

import edu.umd.cs.findbugs.annotations.Nullable;
import xyz.wismer.jimp.project.Project;

/**
 * Interface for providing plugin metadata and automatic update mechanism. Implementations get discovered using Java's
 * {@link java.util.ServiceLoader} mechanism (i.e. they must be registered in META-INF/services/xyz.wismer.jimp.PluginInfo)
 */
public interface PluginInfo {
	/**
	 * Get all the projects provided by this plugin. Instance creation and injection will be done by caller.
	 */
	Collection<Class<? extends Project>> getProjects();

	/**
	 * Get the homepage of this plugin.
	 */
	@Nullable
	URL getHomepage();

    /**
     * Check for plugin updates. If there is none, null is returned, otherwise the update is downloaded to a temporary
     * directory and returned (if successful). Installation will be performed by the caller.
     *
     * @param spiMajorVersion the major SPI version for breaking changes
     * @param spiMinorVersion the minor SPI version for backwards compatible improvements
     */
    @Nullable
    File downloadUpdate(int spiMajorVersion, int spiMinorVersion);
}
