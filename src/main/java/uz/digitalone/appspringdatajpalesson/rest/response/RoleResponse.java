package uz.digitalone.appspringdatajpalesson.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.digitalone.appspringdatajpalesson.entity.enums.RoleName;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 11/2/2022
 * Time: 10:07 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponse {
    private Long id;
    private RoleName roleName;
    private String description;

}
