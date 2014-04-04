package ddd.ecommerce.domain;

import ddd.ecommerce.domain.catalog.Catalog;

import java.util.HashMap;
import java.util.Map;

public class CatalogRepositoryMock implements CatalogRepository {
    Map<String, Catalog> catalogs = new HashMap<String, Catalog>();
    @Override
    public Catalog store(Catalog catalog) {
        catalogs.put(catalog.getName(), catalog);
        return catalog;
    }
}
