package navent;

public enum BumexMemcached {

    INSTANCE;

    void set(String key, Object value) {
        System.out.println("set, key: " + key + " value " + value);
    }

    Object get(String key) {
        System.out.println("get, key: " + key);
        return new Object();
    }

    void delete(String key) {
        System.out.println("delete, key: " + key);
    }

}
