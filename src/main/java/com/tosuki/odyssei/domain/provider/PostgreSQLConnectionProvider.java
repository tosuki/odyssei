package com.tosuki.odyssei.domain.provider;

import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class PostgreSQLConnectionProvider {
    private String hostname;
    private String database;
    private int port;
    private String username;
    private String password;

    private HikariDataSource hikariDataSource;
    
    public PostgreSQLConnectionProvider(
        String database,
        String hostname,
        int port,
        String username, 
        String password
    ) {
        this.hostname = hostname;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    private HikariConfig createHikariConfig() {
        Properties props = new Properties();

        props.setProperty("dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource");
        props.setProperty("dataSource.user", username);
        props.setProperty("dataSource.password", password);
        props.setProperty("dataSource.databaseName", database);
        props.setProperty("dataSource.serverName", hostname);
        props.setProperty("dataSource.portNumber", String.valueOf(port));

        return new HikariConfig(props);
    }

    public void connect() {
        this.hikariDataSource = new HikariDataSource(createHikariConfig());
    }

    public void getConnection() {}

    public void disconnect() {
        hikariDataSource.close();
    }
}
