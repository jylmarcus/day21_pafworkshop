package paf.visa.day21_pafworkshop.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable{
    private Integer id;
    private String firstName;
    private String lastName;
    private Date dob;

}
