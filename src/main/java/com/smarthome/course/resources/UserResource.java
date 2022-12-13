package com.smarthome.course.resources;

import com.smarthome.course.entities.User;
import com.smarthome.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> insert(@RequestBody User user) {
        userService.insert(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/user/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User update(@RequestBody User user, @PathVariable Long id) {
        userService.update(user,id);
        return user;
    }

    @PostMapping("/remove/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "Success. User deleted!!!";
    }
}
