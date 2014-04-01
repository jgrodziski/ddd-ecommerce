package ddd.ecommerce.domain;

/**
 *
 */
public interface Rule<T> {
    public T evaluate();
}
