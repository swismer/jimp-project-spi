package xyz.wismer.jimp;

import java.io.File;
import java.net.URL;

import edu.umd.cs.findbugs.annotations.Nullable;

/**
 * Interface for providing plugin metadata and automatic update mechanism. Implementations get discovered using Java's
 * {@link java.util.ServiceLoader} mechanism (i.e. they must be registered in META-INF/services/xyz.wismer.jimp.PluginInfo)
 */
public interface PluginInfo {
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
