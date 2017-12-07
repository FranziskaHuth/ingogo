package mobi.ingogo.interview.model.error;

import com.sun.xml.internal.bind.v2.TODO;
import mobi.ingogo.interview.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationError.class)
    protected ResponseEntity<Object> handleValidationError(ValidationError error) {
        // TODO: fix me and add me to the controller
        ErrorResponse response = new ErrorResponse(error.getMsg(), error.getCode());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
