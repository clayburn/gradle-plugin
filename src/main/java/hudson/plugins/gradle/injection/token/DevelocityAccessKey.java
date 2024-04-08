package hudson.plugins.gradle.injection.token;

import java.util.Objects;

public class DevelocityAccessKey {
    private final String hostname;
    private final String key;

    private DevelocityAccessKey(String hostname, String key) {
        this.hostname = hostname;
        this.key = key;
    }

    public static DevelocityAccessKey of(String hostname, String key) {
        return new DevelocityAccessKey(hostname, key);
    }

    public static DevelocityAccessKey parse(String rawAccessKey) {
        String[] parts = rawAccessKey.split("=");
        return new DevelocityAccessKey(parts[0], parts[1]);
    }

    public String getRawAccessKey() {
        return hostname + "=" + key;
    }

    public String getHostname() {
        return hostname;
    }

    public String getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DevelocityAccessKey that = (DevelocityAccessKey) o;
        return Objects.equals(hostname, that.hostname) && Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostname, key);
    }
}
