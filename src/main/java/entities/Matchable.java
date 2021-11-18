package entities;

import java.util.Set;

public interface Matchable {
    public Set<String> getMatchers();

    public boolean matches(String id);
}
