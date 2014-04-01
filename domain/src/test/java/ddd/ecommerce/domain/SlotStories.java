package ddd.ecommerce.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SlotStories extends Stories {

    public SlotStories() {
        super();
    }

    protected List<Object> mySteps() {
        List<Object> steps = new ArrayList(1);
        steps.add(new SlotSteps());
        return steps;
    }
}
