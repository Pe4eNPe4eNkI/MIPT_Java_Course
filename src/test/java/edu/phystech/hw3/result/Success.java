package edu.phystech.hw3.result;

import java.util.function.Function;

public record Success<T> (T val) implements Result<T> {

    public static <T> Success<T> of(T t) {
        return new Success<>(t);
    }

    @Override
    public <R> R fold(Function<T, R> onSuccess, Function<Throwable, R> onError) {
        return onSuccess.apply(val);
    }
}