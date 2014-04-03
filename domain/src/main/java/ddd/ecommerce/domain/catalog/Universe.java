package ddd.ecommerce.domain.catalog;

/**
 * Created by jeremiegrodziski on 03/04/14.
 */
public class Universe {
    private String id;
    private String label;

    public Universe(String id, String label) {
        this.id = id;
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
}
