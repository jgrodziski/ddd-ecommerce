package ddd.ecommerce.domain;

import ddd.ecommerce.domain.catalog.Catalog;

public interface CatalogRepository {
    public Catalog store(Catalog catalog);
}
