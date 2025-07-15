package com.tosuki.odyssei.domain.util.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tosuki.odyssei.core.entity.Player;

public class EntitiesMapper {
    public static Player toPlayer(ResultSet resultSet) throws SQLException {
        return Player.builder()
            .username(resultSet.getString("username"))
            .created_at(resultSet.getTimestamp("created_at"))
            .build();
    }
}
