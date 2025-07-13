package com.tosuki.odyssei.core.logger;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoreError extends Error {
    private String ownership;

    public CoreError(String prefix, String message) {
        super(String.format("[%s] %s", prefix, message));
    }

    public CoreError(String message) {
        super(message);
    }
}
