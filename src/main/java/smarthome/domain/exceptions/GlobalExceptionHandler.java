package smarthome.domain.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import smarthome.utils.dto.ErrorResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

  /**
   * Handle IllegalArgumentException
   * @param ex IllegalArgumentException
   * @return ResponseEntity
   */
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
    ErrorResponseDTO errorResponse = new ErrorResponseDTO(
        HttpStatus.BAD_REQUEST.value(),
        ex.getMessage());

    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }

  /**
   * Handle {@link EntityNotFoundException}
   * @param ex EntityNotFoundException
   * @return ResponseEntity
   */
  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NoLogRecordsFoundException.class)
  public ResponseEntity<Object> handleNoLogRecordsFoundException(NoLogRecordsFoundException ex) {
    ErrorResponseDTO errorResponse = new ErrorResponseDTO(
        HttpStatus.NOT_FOUND.value(),
        ex.getMessage());

    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleException(Exception ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }
}