package ru.practicum.exeptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationDateException(final ValidationDateException e) {
        log.info("Дата и время установлены неправильно\n", HttpStatus.BAD_REQUEST);
        return Map.of("Bad Request", e.getMessage());
    }
}