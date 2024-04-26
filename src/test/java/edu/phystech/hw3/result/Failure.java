package edu.phystech.hw3.result;

import java.util.function.Function;

public record Failure<T>(Throwable e) implements Result<T> {

    public static <T> Failure<T> of(Throwable e) {
        return new Failure<>(e);
    }

    @Override
    public <R> R fold(Function<T, R> onSuccess, Function<Throwable, R> onError) {
        return onError.apply(e);
    }
}
