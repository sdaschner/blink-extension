package com.sebastian_daschner.quarkus.blink.extension.runtime;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class Blink1 {

    @Inject
    Blink1Configuration config;

    void onStart(@Observes StartupEvent event) {
        blink(Led.LED_1, config.startupColor());
    }

    void onStop(@Observes ShutdownEvent event) {
        off(Led.BOTH);
    }

    public void blink() {
        blink(Led.LED_2, config.defaultBlinkColor());
    }

    public void off(Led led) {
        executeBlink1Tool("--led=" + led.getLedIndex(), "--off");
    }

    private void blink(Led led, String color) {
        executeBlink1Tool("--led=" + led.getLedIndex(), "--rgb", color);
    }

    private void executeBlink1Tool(String... args) {
        List<String> command = Stream.concat(Stream.of("blink1-tool"), Stream.of(args))
                .collect(Collectors.toList());
        try {
            Process process = new ProcessBuilder(command).start();
            int status = process.waitFor();
            if (status != 0) {
                System.err.println("Could not execute blink1-tool, error: " + new String(process.getInputStream().readAllBytes()));
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Could not execute blink1-tool");
            e.printStackTrace();
        }
    }

    public enum Led {
        LED_1(1), LED_2(2), BOTH(0);

        private final int ledIndex;

        Led(int ledIndex) {
            this.ledIndex = ledIndex;
        }

        public int getLedIndex() {
            return ledIndex;
        }
    }

}
