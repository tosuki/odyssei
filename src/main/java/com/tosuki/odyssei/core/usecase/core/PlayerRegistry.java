package com.tosuki.odyssei.core.usecase.core;

import com.tosuki.odyssei.core.entity.Player;
import com.tosuki.odyssei.core.entity.PlayerAttributes;
import com.tosuki.odyssei.core.logger.PlayerRegistryError;
import com.tosuki.odyssei.core.repository.PlayerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayerRegistry {
    private PlayerRepository playerRepository;

    public void createPlayerRegistry(String username) {
        try {
            if (playerRepository.has(username)) {
                throw new PlayerRegistryError.UsernameOccupied(username);
            }

            Player player = Player.builder()
                .username(username)
                .build();
            
            PlayerAttributes attributes = PlayerAttributes.builder()
                .strength(5)
                .defense(5)
                .speed(5)
                .build();
            
            player.setAttributes(attributes);
            playerRepository.save(player);
        } catch (Exception exception) {
            throw exception;
        }
    }
}
