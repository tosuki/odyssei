package com.tosuki.odyssei.core.entity;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Player {
    private String username;
    private Timestamp created_at;

    private PlayerAttributes attributes;
}
