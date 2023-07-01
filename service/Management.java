package service;

import java.util.function.Consumer;

public interface Management<T> {
    void add(T t);

    T remove(String id);

    void edit(String id, Consumer<T> consumer);


}
