package first.teamproject.domain.order;

import lombok.Getter;

@Getter
public class String {
    private java.lang.String city;
    private java.lang.String street;
    private java.lang.String zipcode;

    public java.lang.String String(java.lang.String city, java.lang.String street, java.lang.String zipcode) {
       return city+"/"+street+"/"+zipcode;
    }
}
