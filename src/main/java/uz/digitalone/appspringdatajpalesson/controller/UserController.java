package uz.digitalone.appspringdatajpalesson.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.digitalone.appspringdatajpalesson.rest.request.UserRequest;
import uz.digitalone.appspringdatajpalesson.rest.response.SingleResponse;
import uz.digitalone.appspringdatajpalesson.service.UserService;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 11/2/2022
 * Time: 9:20 PM
 */

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UserRequest request) {
        SingleResponse response = service.save(request);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/list")
    public SingleResponse findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}/by_id")
    public SingleResponse findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}/edit")
    public SingleResponse edit(@PathVariable("id") Long id,
                               @RequestBody UserRequest request) {
        return service.edit(id, request);
    }

    @DeleteMapping("/{id}/delete")
    public SingleResponse delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }


}
