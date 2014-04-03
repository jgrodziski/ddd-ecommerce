package ddd.ecommerce.domain.common;

/**
 *
 */
public interface Rule<T> {
    public T evaluate();
}
