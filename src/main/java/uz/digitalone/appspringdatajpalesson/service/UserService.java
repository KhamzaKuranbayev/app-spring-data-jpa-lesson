package uz.digitalone.appspringdatajpalesson.service;

import uz.digitalone.appspringdatajpalesson.rest.request.UserRequest;
import uz.digitalone.appspringdatajpalesson.rest.response.SingleResponse;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 11/8/2022
 * Time: 9:19 PM
 */
public interface UserService {
    SingleResponse save(UserRequest request);

    SingleResponse findAll();

    SingleResponse findById(Long id);

    SingleResponse edit(Long id, UserRequest request);

    SingleResponse delete(Long id);
}
