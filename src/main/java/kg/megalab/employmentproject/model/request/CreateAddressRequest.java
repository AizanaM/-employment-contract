package kg.megalab.employmentproject.model.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateAddressRequest {

    String country;
    String city;
    String street;
    String house;
    Integer apartment;
    Long postcode;
}
