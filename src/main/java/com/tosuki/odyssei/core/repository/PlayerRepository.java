package com.tosuki.odyssei.core.repository;

import java.util.Optional;

import com.tosuki.odyssei.core.entity.Player;

public interface PlayerRepository {
    public Optional<Player> getPlayerByUsername(String username);
    public boolean has(String username);
    public void save(Player player);
    public Optional<Player> deleteByUsername(Player player);
}
