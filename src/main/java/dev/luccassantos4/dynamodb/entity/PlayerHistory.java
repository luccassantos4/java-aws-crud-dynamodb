package dev.luccassantos4.dynamodb.entity;

import dev.luccassantos4.dynamodb.dto.ScoreDto;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.time.Instant;
import java.util.UUID;

@DynamoDbBean
public class PlayerHistory {

    private String playerId;

    private UUID gameId;

    private Double score;

    private Instant createdAt;

    public static PlayerHistory fromScore(String playerId, ScoreDto scoreDto) {
        var entity = new PlayerHistory();
        entity.setPlayerId(playerId);
        entity.setGameId(UUID.randomUUID());
        entity.setScore(scoreDto.score());
        entity.setCreatedAt(Instant.now());
        return entity;
    }

    @DynamoDbPartitionKey
    @DynamoDbAttribute("player_id")
    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }


    public void setGameId(UUID gameId) {
        this.gameId = gameId;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("game_id")
    public UUID getGameId() {
        return gameId;
    }

    @DynamoDbAttribute("score")
    public Double getScore() {
        return score;
    }

    @DynamoDbAttribute("created_at")
    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
