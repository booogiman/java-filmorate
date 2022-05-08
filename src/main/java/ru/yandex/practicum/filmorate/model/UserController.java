package ru.yandex.practicum.filmorate.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import ru.yandex.practicum.filmorate.exceptions.ValidationException;
import ru.yandex.practicum.filmorate.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
    private final Map<String, User> users = new HashMap<>();
    private int id = 1;

    @GetMapping
    public Collection<User> findAll() {
        return users.values();
    }

    @PostMapping
    public User create(@Valid @RequestBody User user) {

        if (user.getName() == null || user.getName().isBlank()) {
            user.setName(user.getLogin());
            log.info("Имя пользователя не указано, вместо имени будет использован логин.");
        }

        user.setId(id);
        id++;
        users.put(user.getEmail(), user);
        log.info("Создан пользователь {}", user, toString());
        return user;
    }

    @PutMapping
    public User change(@Valid @RequestBody User user) throws ValidationException {

        if (user.getName() == null || !user.getEmail().contains("@") || user.getEmail().isBlank()) {
            throw new ValidationException("Адрес электронной почты не может быть пустым.");
        }
        users.put(user.getEmail(), user);
        log.info("Пользователь " + user.getEmail() + " изменен.");

        return user;
    }
}
