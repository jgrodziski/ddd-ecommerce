package ddd.ecommerce.domain.catalog;

/**
 * Created by jeremiegrodziski on 03/04/14.
 */
public class Family {
    private String id;
    private String label;
    private Universe parent;

    public Family(String id, String label, Universe parent) {
        this.id = id;
        this.label = label;
        this.parent = parent;
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
}
