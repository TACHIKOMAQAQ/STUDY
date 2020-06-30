import java.util.Optional;

/**
 * @author ：mmzs
 * @date ：Created in 2019/12/5 15:25
 */
public class OptionalTest {
    public static void main(String[] args) {
        Product product = null;
        Optional.ofNullable(product).map(c->c.sale());
    }
}

class Product{
    public Product sale(){
        System.out.println("sale");
        return this;
    }
}
