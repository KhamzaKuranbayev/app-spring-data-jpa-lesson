package uz.digitalone.appspringdatajpalesson.rest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import uz.digitalone.appspringdatajpalesson.entity.Category;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 11/10/2022
 * Time: 10:27 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRequest {
    private String name;
    private String color;
    private LocalDate year;
    private Double price;
    private Set<Long> categoryIdSet = new HashSet<>();
}
