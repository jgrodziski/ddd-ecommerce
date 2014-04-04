package ddd.ecommerce.domain.catalog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jeremiegrodziski on 03/04/14.
 */
public class Universe {
    private String id;
    private String label;
    private Map<String, Family> families;

    public Universe(String id, String label) {
        this.id = id;
        this.label = label;
        families = new HashMap<String, Family>();
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public Family add(Family family) {
        families.put(family.getId(), family);
        return family;
    }

    public Family getFamily(String familyId){
        return families.get(familyId);
    }
}
