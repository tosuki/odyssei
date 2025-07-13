package com.tosuki.odyssei.domain.repository;

import java.util.Optional;

import com.tosuki.odyssei.core.entity.Player;
import com.tosuki.odyssei.core.repository.PlayerRepository;

public class PlayerPostgresqlRepositoryImpl implements PlayerRepository {
    /**
     * CREATE TABLE IF NOT EXISTS players (
     *   username VARCHAR UNIQUE NOT NULL
     *   
     * );
     */
    public void initialize() {
        //initialize postgresql table xD
    }

    /**
     * 
     */
    @Override
    public Optional<Player> getPlayerByUsername(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlayerByUsername'");
    }

    @Override
    public boolean has(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'has'");
    }

    @Override
    public void save(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<Player> deleteByUsername(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByUsername'");
    }
    
}
