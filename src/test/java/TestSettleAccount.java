import com.netease.meta.Cart;
import org.springframework.ui.ModelMap;
import junit.textui.TestRunner;

import junit.runner.*;

/**
 * Created by zjlearn on 2017/3/8.
 */
public class TestSettleAccount {

    public String test(ModelMap model){
        Cart cart= new Cart();
        int id=2;
        float price=4.5f;
        String title="girl";
        int num=12;
        cart.addproduct(Integer.toString(id),price,title, num);
        return "settleAccount";
    }
}
