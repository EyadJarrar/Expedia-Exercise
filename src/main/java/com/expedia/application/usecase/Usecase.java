package com.expedia.application.usecase;

@FunctionalInterface
public interface Usecase<R, S> {

    S execute(R r);
}
