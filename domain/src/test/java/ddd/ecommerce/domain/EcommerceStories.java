package ddd.ecommerce.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class EcommerceStories extends Stories {

    public EcommerceStories() {
        super();
    }

    protected List<Object> mySteps() {
        List<Object> steps = new ArrayList(1);

        steps.add(new CatalogSteps());
        steps.add(new CustomerSteps());

        return steps;
    }
}
