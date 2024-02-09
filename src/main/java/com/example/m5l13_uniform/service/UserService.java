package com.example.m5l13_uniform.service;

import com.example.m5l13_uniform.entity.User;
import com.example.m5l13_uniform.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository repo;

    public Mono<User> findById(Long id){
        // Where is my DTO?
        return repo.findById(id);

    }

    public Flux<User> findAll(){
        Flux<User> all = repo.findAll();
        return all;
    }

    public Mono<User> save(User user){
        return repo.save(user);
    }

    public void delete(User user){
        Mono<Void> delete = repo.delete(user);
    }

    public Mono<Void> deleteById(Long id){
        return repo.deleteById(id);
    }


}
