package uz.digitalone.appspringdatajpalesson.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 11/10/2022
 * Time: 10:53 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private Long id;
    private String name;
    private String color;
    private LocalDate year;
    private Double price;
    private Set<CategoryDto> categorySet = new HashSet<>();
}
