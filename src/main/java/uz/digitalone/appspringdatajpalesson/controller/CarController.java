package uz.digitalone.appspringdatajpalesson.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.digitalone.appspringdatajpalesson.rest.request.CarRequest;
import uz.digitalone.appspringdatajpalesson.rest.response.SingleResponse;
import uz.digitalone.appspringdatajpalesson.service.CarService;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 11/2/2022
 * Time: 9:20 PM
 */

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService service;

    @PostMapping("/save")
    public ResponseEntity<SingleResponse> save(@RequestBody CarRequest request) {
        SingleResponse response = service.save(request);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/list")
    public SingleResponse findAll() {
        SingleResponse response = service.findAll();
        return response;
    }


}
