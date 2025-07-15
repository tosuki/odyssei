package com.tosuki.odyssei.core.repository;

import java.sql.SQLException;
import java.util.Optional;

import com.tosuki.odyssei.core.entity.Player;

public interface PlayerRepository {
    public Optional<Player> getPlayerByUsername(String username) throws SQLException;
    public boolean has(String username);
    public void save(Player player);
    public Optional<Player> deleteByUsername(String username);
}
