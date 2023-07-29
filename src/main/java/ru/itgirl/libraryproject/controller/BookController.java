package ru.itgirl.libraryproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirl.libraryproject.dto.BookDto;
import ru.itgirl.libraryproject.service.BookService;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
 //http://localhost:8080/book?name=Нос
    @GetMapping("/book")
    BookDto getBookByNaneV1(@RequestParam("name") String name) {
        return bookService.getByNameV1(name);
    }

    //http://localhost:8080/book/v2?name=Нос
    @GetMapping("/book/v2")
    BookDto getBookByNaneV2(@RequestParam("name") String name) {
        return bookService.getByNameV2(name);
    }

    //http://localhost:8080/book/v3?name=Война%20и%20мир
    @GetMapping("/book/v3")
    BookDto getBookByNaneV3(@RequestParam("name") String name) {
        return bookService.getByNameV3 (name);
    }
}
