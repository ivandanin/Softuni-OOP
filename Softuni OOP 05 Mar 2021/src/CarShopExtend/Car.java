package CarShopExtend;

import java.io.Serializable;

public interface Car {
    Integer TIRES = 4;

    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();

}
