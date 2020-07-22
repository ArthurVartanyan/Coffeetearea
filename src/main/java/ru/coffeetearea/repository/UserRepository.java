package ru.coffeetearea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}