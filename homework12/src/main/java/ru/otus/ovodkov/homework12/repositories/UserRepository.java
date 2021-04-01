package ru.otus.ovodkov.homework12.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.ovodkov.homework12.entities.User;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Ovodkov Sergey
 * created on 28.03.2021
 */
public interface UserRepository extends JpaRepository<User, UUID> {

  Optional<User> findByUsername(String username);
}
