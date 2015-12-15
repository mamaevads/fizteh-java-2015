package ru.fizteh.fivt.students.mamaevads.collectionquery.impl;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Даша on 01.11.2015.
 */


public class FromStmt<T> {
    public static <T> FromStmt<T> from(Iterable<T> iterable) {
        throw new UnsupportedOperationException();
    }

    public static <T> FromStmt<T> from(Stream<T> stream) {
        throw new UnsupportedOperationException();
    }

    @SafeVarargs
    public final <R> Selector<T, R> select(Class<R> clazz, Function<T, ?>... s) {
        throw new UnsupportedOperationException();
    }

    @SafeVarargs
    public final <R> Selector<T, R> selectDistinct(Class<R> clazz, Function<T, ?>... s) {
        throw new UnsupportedOperationException();
    }
}