package com.tosuki.odyssei.core.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PlayerAttributes {
    public String playerUsername;

    private int strength;
    public int defense;
    public int speed;
}
