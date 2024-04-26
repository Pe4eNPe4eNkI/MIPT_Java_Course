package edu.phystech.hw3.result;

import java.util.function.Function;

public sealed interface Result<T> permits Failure, Success {
    @SuppressWarnings("unchecked")
    default <R> Result<R> map(Function<? super T, ? extends R> mapper) {
        return (Result<R>) fold(v -> Success.of(mapper.apply(v)), __ -> this);
    }

    default boolean isSuccess() {
        return fold(__ -> true, __ -> false);
    }

    default boolean isFailure() {
        return !isSuccess();
    }

    default T getOrDefault(T defaultValue) {
        return getOrElse(e -> defaultValue);
    }

    default T getOrElse(Function<Throwable, T> func) {
        return fold(v -> v, func);
    }
    default Throwable getExceptionOrNull() {
        return fold(__ -> null, e -> e);
    }


    <R> R fold(Function<T, R> onSuccess, Function<Throwable,R> onError);
}