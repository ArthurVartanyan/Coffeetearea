package ru.coffeetearea.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.coffeetearea.dto.ErrorsDTO;
import ru.coffeetearea.dto.FieldErrorDTO;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    /**
     * NullPointerException
     *
     * @param ex
     * @return message
     */
    @ResponseBody
    @ExceptionHandler(MainNullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String NullPointerHandler(MainNullPointerException ex) {
        return ex.getMessage();
    }


    /**
     * NotFoundException
     *
     * @param ex
     * @return message
     */
    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String NotFoundHandler(EntityNotFoundException ex) {
        return ex.getMessage();
    }


    /**
     * BadRequestException
     *
     * @param ex
     * @return message
     */
    @ResponseBody
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsDTO BadRequestHandler(BadRequestException ex) {

        ErrorsDTO errorsDTO = new ErrorsDTO();
        errorsDTO.setError(ex.getMessage());

        return errorsDTO;
    }


    /**
     * AuthenticationServiceException
     *
     * @param ex
     * @return message
     */
    @ResponseBody
    @ExceptionHandler(AuthenticationServiceException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String AuthenticationServiceHandler(AuthenticationServiceException ex) {
        return ex.getMessage();
    }


    /**
     * ResponseEntity HANDLE
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return new ResponseEntity<>
     */

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        List<FieldErrorDTO> fieldErrors = new ArrayList<>();

        List<ObjectError> objectErrors = ex.getBindingResult().getAllErrors();

        for (ObjectError o : objectErrors) {

            String fieldName = ((FieldError) o).getField();
            String errorMessage = o.getDefaultMessage();
            FieldErrorDTO f = new FieldErrorDTO();
            f.setField(fieldName);
            f.setMessage(errorMessage);

            fieldErrors.add(f);
        }
        return new ResponseEntity<>(fieldErrors, HttpStatus.BAD_REQUEST);
    }
}