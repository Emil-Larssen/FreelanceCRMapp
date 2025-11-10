package dev.emil.sales.domain.prospect;
import java.util.UUID;

public final class Prospect {
    private final UUID id;
    private final String name;

    private Prospect(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
    public static Prospect create(String name) {
        return new Prospect(UUID.randomUUID(), name);
    }
    public UUID getUUID() {
        return this.id;
    }
}
