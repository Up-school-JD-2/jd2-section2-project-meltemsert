package service;

import java.util.Comparator;
import java.util.Map;

public interface Sort<T> {
    void sort(Map<String, T> map, Comparator<T> comparator);
}
