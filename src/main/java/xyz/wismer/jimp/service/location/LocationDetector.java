package xyz.wismer.jimp.service.location;

/**
 * A detector for the current working location. Implementations get discovered using Java's
 * {@link java.util.ServiceLoader} mechanism (i.e. they must be registered in
 * META-INF/services/xyz.wismer.jimp.service.location.LocationDetector)
 */
public interface LocationDetector {
    enum Location {OFFICE, HOME_OFFICE, UNKNOWN}

    /**
     * Detect the current location.
     */
    Location detectLocation();
}
