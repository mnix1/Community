package community.game;

import java.util.Objects;
import java.util.UUID;

public class Id {
    private final String value;

    public Id(String value) {
        this.value = value;
    }

    public static Id random() {
        return new Id(UUID.randomUUID().toString());
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id id = (Id) o;
        return Objects.equals(value, id.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
