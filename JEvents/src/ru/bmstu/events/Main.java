package ru.bmstu.events;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

interface MetronomeEvent {
    void tick();
}

public class Main {

    public static void main(String[] args) {
        Metronome metronome = new Metronome();
        metronome.addListener(Main::time);
        metronome.start();
    }

    private static void time() {
        System.out.println("Time now: " + LocalDateTime.now());
    }
}

class Metronome {
    private List<MetronomeEvent> listeners;

    void addListener(MetronomeEvent listener) {
        if (listeners == null) {
            listeners = new ArrayList<>();
        }
        listeners.add(listener);
    }

    void start() {
        while (true) {
            try {
                Thread.sleep(1000);
                if (listeners != null) {
                    listeners.forEach(MetronomeEvent::tick);
                }
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}