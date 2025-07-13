package com.tosuki.odyssei.domain.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;

import com.tosuki.odyssei.core.entity.Player;
import com.tosuki.odyssei.core.repository.PlayerRepository;
import com.tosuki.odyssei.domain.provider.PostgreSQLConnectionProvider;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayerPostgresqlRepositoryImpl implements PlayerRepository {
    private PostgreSQLConnectionProvider connectionProvider;
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
