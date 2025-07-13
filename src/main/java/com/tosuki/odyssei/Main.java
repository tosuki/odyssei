package com.tosuki.odyssei;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("hello world");
    }

    @Override
    public void onDisable() {
        System.out.println("Bye!");
    }
}