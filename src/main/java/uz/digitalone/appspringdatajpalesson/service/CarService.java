package uz.digitalone.appspringdatajpalesson.service;

import uz.digitalone.appspringdatajpalesson.rest.request.CarRequest;
import uz.digitalone.appspringdatajpalesson.rest.response.SingleResponse;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 11/10/2022
 * Time: 10:25 PM
 */
public interface CarService {
    SingleResponse save(CarRequest request);

    SingleResponse findAll();

}
