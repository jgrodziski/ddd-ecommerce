package ddd.ecommerce.domain.catalog;

import java.util.HashMap;
import java.util.Map;

public class CatalogRepositoryMock implements CatalogRepository {
    Map<String, Catalog> catalogs = new HashMap<String, Catalog>();
    @Override
    public Catalog store(Catalog catalog) {
        catalogs.put(catalog.getName(), catalog);
        return catalog;
    }

    public Catalog findByName(String name){
        for (Catalog catalog : catalogs.values()) {
            if (catalog.getName().equals(name)) {
                return catalog;
            }
        }
        throw new RuntimeException("Catalog with name "+name+" not found.");
    }
}
