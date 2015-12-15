package ru.fizteh.fivt.students.mamaevads.collectionquery.impl;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by Даша on 01.11.2015.
 */


public class Selector<T, R> {

    @SafeVarargs
    public Selector(Function<T, R>... s) {
        throw new UnsupportedOperationException();
    }

    public WhereStmt<T, R> where(Predicate<T> predicate) {
        throw new UnsupportedOperationException();
    }

    public Iterable<R> execute() {
        throw new UnsupportedOperationException();
    }

    public Stream<R> stream() {
        throw new UnsupportedOperationException();
    }

    public class WhereStmt<T, R> {
        @SafeVarargs
        public final WhereStmt<T, R> groupBy(Function<T, ?>... expressions) {
            throw new UnsupportedOperationException();
        }

        @SafeVarargs
        public final WhereStmt<T, R> orderBy(Comparator<T>... comparators) {
            throw new UnsupportedOperationException();
        }

        public WhereStmt<T, R> having(Predicate<R> condition) {
            throw new UnsupportedOperationException();
        }

        public WhereStmt<T, R> limit(int amount) {
            throw new UnsupportedOperationException();
        }

        public UnionStmt union() {
            throw new UnsupportedOperationException();
        }
    }

}