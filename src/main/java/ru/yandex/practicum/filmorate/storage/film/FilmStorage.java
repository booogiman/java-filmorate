package ru.yandex.practicum.filmorate.storage.film;

import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.List;
import java.util.Map;

public interface FilmStorage {
    Film create(Film film) throws Exception; // Метод создающий/Добавляющий фильм в хранилище
    Film update(Film film) throws Exception; // Метод обновляющий фильм или если такого фильма нет,
    // создает новый фильм (Модификация)
    void delete(Film film) throws Exception; // Метод удаляющий фильм
    List<Film> getFilms() throws Exception; // Метод по получению всех фильмов
    Film getFilmById(Long id) throws Exception; // Метод по получени одного фильма
}
