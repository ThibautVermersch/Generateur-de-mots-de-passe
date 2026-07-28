import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private List<Item> stock = new ArrayList<>();

    public VendingMachine() {
        stock.add(new Item("Coca-Cola", 2.50, 11));
        stock.add(new Item("Eau", 1.00, 1));
        stock.add(new Item("Dragibus", 3.00, 7));
        stock.add(new Item("Café", 1.00, 50));
    }

    public void afficherStock() {
        System.out.println();
        int n = 1;
        for (var item : stock) {
            item.afficherInfos(n++);
        }
        System.out.println();
    }

    public Item getItem(int index) {
        return stock.get(index);
    }

    public int getTailleStock() {
        return stock.size();
    }

}
