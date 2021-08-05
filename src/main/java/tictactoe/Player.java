package tictactoe;

import java.util.UUID;

public class Player {
    private final String userUUID;
    private final String name;
    private final Statistic stats;

    public Player(String userUUID, String name, Statistic stats) {
        this.userUUID = userUUID;
        this.name = name;
        this.stats = stats;
    }

    public Player(String userUUID, String name) {
        this(userUUID, name, new Statistic());
    }

    public Player(String name) {
        this(UUID.randomUUID().toString(), name, new Statistic());
    }

    public String getUserUUID() {
        return userUUID;
    }

    public String getName() {
        return name;
    }

    public Statistic getStats() {
        return stats;
    }

    @Override
    public String toString() {
        return "Player{" +
                "userUUID='" + userUUID + '\'' +
                ", name='" + name + '\'' +
                ", stats=" + stats +
                '}';
    }
}