package ddd.ecommerce.domain.catalog;

/**
 * Created by jeremiegrodziski on 03/04/14.
 */
public class Category {
    private String id;
    private String label;
    private Family family;

    public Category(String id, String label, Family family) {
        this.id = id;
        this.label = label;
        this.family = family;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public Family getFamily() {
        return family;
    }
}
