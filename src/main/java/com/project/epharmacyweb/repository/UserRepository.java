package com.project.epharmacyweb.repository;

import com.project.epharmacyweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByConfirmationToken(String confirmationToken);

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmailAndConfirmationStatus(String email, String confirmationStatus);
}
