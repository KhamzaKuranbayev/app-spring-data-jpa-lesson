package uz.digitalone.appspringdatajpalesson.controller;

import org.springframework.web.bind.annotation.*;
import uz.digitalone.appspringdatajpalesson.entity.Role;
import uz.digitalone.appspringdatajpalesson.rest.dto.RoleDto;
import uz.digitalone.appspringdatajpalesson.rest.response.SingleResponse;
import uz.digitalone.appspringdatajpalesson.service.RoleService;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 11/2/2022
 * Time: 9:20 PM
 */

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public SingleResponse save(@RequestBody RoleDto dto) {
        return service.save(dto);
    }

    @GetMapping("/list")
    public SingleResponse findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}/by_id")
    public SingleResponse findById(@PathVariable("id") Long roleId) {
        return service.findById(roleId);
    }

    @PutMapping("/{id}/edit")
    public SingleResponse edit(@PathVariable("id") Long roleId,
                               @RequestBody RoleDto dto) {
        return service.edit(roleId, dto);
    }

    @DeleteMapping("/{id}/delete")
    public SingleResponse delete(@PathVariable("id") Long roleId) {
        return service.delete(roleId);
    }


}
