package ddd.ecommerce.domain.catalog;

import ddd.ecommerce.domain.catalog.Catalog;

public interface CatalogRepository {
    public Catalog store(Catalog catalog);
}
