package first.teamproject.domain.item;

import first.teamproject.domain.order.OrderItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Item {
    private Long itemNo;
    private String itemName;
    private int itemPrice;
    private int itemQuantity;


    public Item(String itemName, int itemPrice, int itemStock) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemStock;
    }

    public void addQuantity(int quantity){
        this.itemQuantity+=quantity;
    }


    public void removeQuantity(int orderQuantity) throws Exception {
        int restQuantity = this.itemQuantity-orderQuantity;
        if(restQuantity<0){
            throw new Exception("need more Quantity");
        }
        this.itemQuantity = restQuantity;
    }
}
