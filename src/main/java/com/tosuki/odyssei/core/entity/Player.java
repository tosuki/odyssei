package com.tosuki.odyssei.core.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Player {
    private String username;
    private Long timestamp;

    private PlayerAttributes attributes;
}
