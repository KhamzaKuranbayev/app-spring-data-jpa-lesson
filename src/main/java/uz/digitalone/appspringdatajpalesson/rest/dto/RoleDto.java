package uz.digitalone.appspringdatajpalesson.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.digitalone.appspringdatajpalesson.entity.enums.RoleName;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 11/2/2022
 * Time: 9:55 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private RoleName roleName;
    private String description;
}
