package com.tosuki.odyssei.domain.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.tosuki.odyssei.core.entity.Player;
import com.tosuki.odyssei.core.logger.CriticalError;
import com.tosuki.odyssei.core.repository.PlayerRepository;
import com.tosuki.odyssei.domain.provider.PostgreSQLConnectionProvider;
import com.tosuki.odyssei.domain.util.mapper.EntitiesMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayerPostgresqlRepositoryImpl implements PlayerRepository {
    private PostgreSQLConnectionProvider connectionProvider;

    public void initialize() {
        try (
            Connection connection = connectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS players(username VARCHAR PRIMARY KEY NOT NULL, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, role SMALLINT DEFAULT 0);"
            );
        ) {
            preparedStatement.execute();
        } catch (Exception e) {
            throw new CriticalError.IllegalException(e);
        }
    }

    /**
     * @throws Exception 
     * 
     */
    @Override
    public Optional<Player> getPlayerByUsername(String username) throws SQLException {
        try (
            Connection connection = connectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM players WHERE username = ?;"
            );
        ) {
            preparedStatement.setString(0, username);
            
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.first()) {
                return Optional.empty();
            }

            return Optional.of(EntitiesMapper.toPlayer(resultSet));
        } catch (Exception e) {
            throw new CriticalError.IllegalException(e);
        }
    }

    @Override
    public boolean has(String username) {
        try (
            Connection connection = connectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT username FROM players WHERE username=?"
            );
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();

            return !!resultSet.isFirst();
        } catch (Exception e) {
            throw new CriticalError.IllegalException(e);
        }
    }

    @Override
    public void save(Player player) {
        try (
            Connection connection = connectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO players (username, created_at) VALUES (?, ?);"
            );
        ) {
            preparedStatement.setString(0, player.getUsername());
            preparedStatement.setTimestamp(1, player.getCreated_at());

            preparedStatement.execute();
        } catch (Exception e) {
            throw new CriticalError.IllegalException(e);
        }
    }

    @Override
    public Optional<Player> deleteByUsername(String username) {
        try (
            Connection connection = connectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE VALUES FROM players WHERE username = ? RETURNING *;"
            );

            ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            if (!resultSet.first()) {
                return Optional.empty();
            }

            return Optional.of(EntitiesMapper.toPlayer(resultSet));
        } catch (Exception e) {
            throw new CriticalError.IllegalException(e);
        }
    }
    
}
