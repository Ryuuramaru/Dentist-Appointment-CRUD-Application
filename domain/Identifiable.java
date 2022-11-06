package domain;

import java.util.Objects;

public abstract class Identifiable {
    private final String id;

    public Identifiable() {
        this.id = "none";
    }

    public Identifiable(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Identifiable identifiable = (Identifiable) o;
        return Objects.equals(id, identifiable.id);
    }
}
