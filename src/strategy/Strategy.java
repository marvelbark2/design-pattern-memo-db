package strategy;

import db.BaseRecord;

import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
public interface Strategy <T extends BaseRecord> extends Function<T, Integer> {
}
