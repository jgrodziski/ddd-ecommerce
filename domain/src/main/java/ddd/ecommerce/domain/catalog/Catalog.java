package ddd.ecommerce.domain.catalog;

import java.util.List;
import java.util.Map;


public class Catalog {
    private String name;
    Map<String, Universe> universes;


    public Catalog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Universe getUniverse(String id){
        return universes.get(id);
    }

    public void add(Universe universe){
        universes.put(universe.getId(), universe);
    }
}
