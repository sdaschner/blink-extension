package com.sebastian_daschner.quarkus.blink.extension.deployment;

import com.sebastian_daschner.quarkus.blink.extension.runtime.BlinkResource;
import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import com.sebastian_daschner.quarkus.blink.extension.runtime.Blink1;

class BlinkExtensionProcessor {

    private static final String FEATURE = "blink-extension";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    AdditionalBeanBuildItem createBlink1() {
        return new AdditionalBeanBuildItem(Blink1.class);
    }

    @BuildStep
    AdditionalBeanBuildItem createBlinkResource() {
        return new AdditionalBeanBuildItem(BlinkResource.class);
    }
}
