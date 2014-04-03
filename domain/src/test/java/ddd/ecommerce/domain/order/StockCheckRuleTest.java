package ddd.ecommerce.domain.order;

import ddd.ecommerce.domain.common.Quantity;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Training on 4/3/2014.
 */
public class StockCheckRuleTest {
    StockCheckRule stockCheckRule = StockCheckRule.INSTANCE;
    @Test
    public void testCheckStockAvailableSuccess() {
        Quantity orderLineQty = Quantity.valueOf(10);
        Quantity stockQty = Quantity.valueOf(15);
        assert(stockCheckRule.checkStockAvailable(orderLineQty,stockQty) == true);
    }

    @Test
    public void testCheckStockCanBeEmpty() {
        Quantity orderLineQty = Quantity.valueOf(10);
        Quantity stockQty = Quantity.valueOf(10);
        assert(stockCheckRule.checkStockAvailable(orderLineQty,stockQty) == true);
    }

    @Test
    public void testCheckStockAvailableFail() {
        Quantity orderLineQty = Quantity.valueOf(10);
        Quantity stockQty = Quantity.valueOf(9);
        assert(stockCheckRule.checkStockAvailable(orderLineQty,stockQty) == false);
    }
}
