package com.sebastian_daschner.quarkus.blink.extension.runtime;

import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

@ConfigMapping(prefix = "quarkus.blink1")
@ConfigRoot(phase = ConfigPhase.RUN_TIME)
public interface Blink1Configuration {

    /**
     * The color of LED 1 on application startup.
     */
    @WithDefault("#00ff00")
    String startupColor();

    /**
     * The default color of the custom blink invocations.
     */
    @WithDefault("#ffffff")
    String defaultBlinkColor();

}
