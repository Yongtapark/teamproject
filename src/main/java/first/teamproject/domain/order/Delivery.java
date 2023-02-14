package first.teamproject.domain.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Delivery {
    private Long deliveryId;
    private Order order;
    private java.lang.String string;
    private DeliveryStatus status;
}
