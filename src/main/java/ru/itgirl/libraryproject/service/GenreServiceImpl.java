package ru.itgirl.libraryproject.service;

import org.springframework.stereotype.Service;
import ru.itgirl.libraryproject.dto.AuthorAndBookDto;
import ru.itgirl.libraryproject.dto.AuthorDto;
import ru.itgirl.libraryproject.dto.BookDto;
import ru.itgirl.libraryproject.dto.GenreDto;
import ru.itgirl.libraryproject.model.Genre;
import ru.itgirl.libraryproject.repository.GenreRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public GenreDto getGenreById(Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        List<AuthorAndBookDto> authorAndBookDtos = genre.getBooks()
                .stream()
                .map(book -> AuthorAndBookDto.builder()
                        .id(book.getId())
                        .name(book.getName())
                        .author(book.getAuthors()
                                .stream()
                                .map(author -> author.getName() +" "+ author.getSurname())
                                .collect(Collectors.joining())) //,
                        .build()
                ).toList();
        GenreDto genreDto = new GenreDto();
        genreDto.setName(genre.getName());
        genreDto.setBooks(authorAndBookDtos);
        return genreDto;

    }

}
