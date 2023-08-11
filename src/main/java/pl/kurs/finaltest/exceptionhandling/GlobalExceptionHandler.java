package pl.kurs.finaltest.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.kurs.finaltest.exceptionhandling.exceptions.BadEntityException;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleEntityNotFoundException(EntityNotFoundException e) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                List.of(e.getMessage()),
                "NOT FOUND",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDto);
    }

    @ExceptionHandler({BadEntityException.class, IllegalArgumentException.class})
    public ResponseEntity<ExceptionResponseDto> handleBadEntityExceptionAndIllegalArgumentException(RuntimeException e) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                List.of(e.getMessage()),
                "BAD REQUEST",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponseDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> errorMessages =e.getFieldErrors()
                .stream()
                .map(fieldError -> "field: " + fieldError.getField() + " / rejected value: '"
                         + fieldError.getRejectedValue() + "' / message: "
                        + fieldError.getDefaultMessage())
                .collect(Collectors.toList());
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                errorMessages,
                "BAD REQUEST",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponseDto);
    }

}
