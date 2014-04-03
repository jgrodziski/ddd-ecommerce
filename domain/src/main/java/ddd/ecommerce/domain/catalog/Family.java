package ddd.ecommerce.domain.catalog;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeremiegrodziski on 03/04/14.
 */
public class Family {
    private String id;
    private String label;
    private Universe parent;
    private Map<String, Category> categories;

    public Family(String id, String label, Universe parent) {
        this.id = id;
        this.label = label;
        this.parent = parent;
        categories = new HashMap<String, Category>();
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public Universe getParent() {
        return parent;
    }

    public void add(Category category) {
        categories.put(category.getId(), category);
    }

    public Category getCategory(String categoryId){
        return categories.get(categoryId);
    }
}
