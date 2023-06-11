import lombok.*;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
    private int id;
    @Getter(AccessLevel.PROTECTED)
    @EqualsAndHashCode.Include
    private String name;
    @Getter(AccessLevel.PROTECTED)
    private double price;
    @Getter(AccessLevel.PROTECTED)
    private Date expirationDate;


}

