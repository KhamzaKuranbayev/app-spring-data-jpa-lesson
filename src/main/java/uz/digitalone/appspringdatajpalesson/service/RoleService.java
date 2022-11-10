package uz.digitalone.appspringdatajpalesson.service;

import uz.digitalone.appspringdatajpalesson.rest.dto.RoleDto;
import uz.digitalone.appspringdatajpalesson.rest.response.SingleResponse;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 11/2/2022
 * Time: 9:30 PM
 */
public interface RoleService {
    SingleResponse save(RoleDto dto);

    SingleResponse findAll();

    SingleResponse findById(Long roleId);

    SingleResponse edit(Long roleId, RoleDto dto);

    SingleResponse delete(Long roleId);
}
