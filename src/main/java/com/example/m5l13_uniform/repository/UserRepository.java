package com.example.m5l13_uniform.repository;

import com.example.m5l13_uniform.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends ReactiveCrudRepository<User, Long> {

   // public Mono<Void> deleteById();

}
