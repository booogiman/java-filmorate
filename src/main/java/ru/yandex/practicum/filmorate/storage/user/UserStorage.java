package ru.yandex.practicum.filmorate.storage.user;


import ru.yandex.practicum.filmorate.model.User;

import java.util.List;


public interface UserStorage {

    User create(User user) throws Exception; // Метод создающий/Добавляющий пользователя в хранилище

    User update(User user) throws Exception; // Метод обновляющий пользователя или если такого пользователя

    // нет, создает нового (Модификация)
    void delete(User user) throws Exception; // Метод удаляющий пользователя

    List<User> getUsers() throws Exception; // Метод по возвращению всех пользователей

    User getUserById(long id) throws Exception; // Метод возвращающий пользователя по ID
}
