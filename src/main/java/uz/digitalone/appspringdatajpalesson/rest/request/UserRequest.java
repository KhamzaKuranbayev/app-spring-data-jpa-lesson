package uz.digitalone.appspringdatajpalesson.rest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.digitalone.appspringdatajpalesson.entity.Role;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 11/8/2022
 * Time: 9:23 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String password;
    private Long roleId;
}
