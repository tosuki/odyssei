package com.tosuki.odyssei.core.logger;

public class PlayerRegistryError extends CoreError {
    public PlayerRegistryError(String message) {
        super("Player Registry", message);
    }

    public static class UsernameOccupied extends PlayerRegistryError {
        public UsernameOccupied(String username) {
            super(String.format("Username '%s' is already occupied in the player registry.", username));
        }
    }
}
