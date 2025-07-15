package com.tosuki.odyssei.core.logger;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoreError extends Error {
    private ArrayList<String> ownerships = new ArrayList<>();

    public CoreError(String prefix, String message) {
        super(String.format("[%s] %s", prefix, message));
    }

    public CoreError(String message) {
        super(message);
    }

    public void addOwnership(String layer) {
        ownerships.add(layer);
    }

    @Override
    public String getMessage() {
        return String.format("%s --> %s", ownerships, super.getMessage());
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
