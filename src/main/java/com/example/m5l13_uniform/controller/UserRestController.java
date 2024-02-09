package com.example.m5l13_uniform.controller;

import com.example.m5l13_uniform.entity.User;
import com.example.m5l13_uniform.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/restapi/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    // GET
    private final UserService userService;

    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Flux<User> findAll(){
        return userService.findAll();
    }

    // CREATE

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> create(User user){
        return userService.save(user);
    }

    public Mono<User> update(@PathVariable Long id, @RequestBody User user){
        if (id.equals(user.getId())){
            return userService.save(user);
        }
        else
        {
            log.error("update with incorrect id = {}", id);
            return Mono.error(new IllegalStateException("incorrect id"));
        }
    }

    // DELETE

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(Long id) {
        return userService.deleteById(id);
    }
}
