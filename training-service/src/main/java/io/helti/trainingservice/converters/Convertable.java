package io.helti.trainingservice.converters;

public interface Convertable {
	<T, E> T from(E source);
	<T, E> T to(E source);
}
