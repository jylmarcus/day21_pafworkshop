package paf.visa.day21_pafworkshop.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable{
    
    private Integer id;

    private Integer customerId;
    
    private LocalDateTime orderDate;

    private LocalDateTime shippedDate;

    private String shipName;
}
