CREATE TABLE IF NOT EXISTS players(
    username VARCHAR(255) PRIMARY KEY NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS player_attributes(
    username VARCHAR(255) NOT NULL,
    strength INT DEFAULT 0,
    defense INT DEFAULT 0,
    speed INT DEFAULT 0,
    FOREIGN KEY (username) REFERENCES players(username) ON DELETE CASCADE
);
