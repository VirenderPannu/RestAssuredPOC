package staleElement.RestAssuredPOC.model;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String flat_no;
    private int pincode;
    private String type;
}
