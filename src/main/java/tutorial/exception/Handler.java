package tutorial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RestControllerAdvice
public class Handler {

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public void handler(HttpMessageNotReadableException e, HttpServletResponse response) throws IOException {
        String message = "Invalid value given in request body. " + convertHttpReadableExceptionMessage(e.getMessage());
        response.sendError( HttpStatus.BAD_REQUEST.value(), message );
    }

    private String convertHttpReadableExceptionMessage(String message){
        String firstLine = message.substring( message.indexOf( "type" ), message.indexOf( "\n" ) );
        String[] s = firstLine.split( " " );
        String[] fields = message.split( "\"" );
        String fieldName = fields[fields.length-2];
        String requiredValue = s[s.length -2];
        String givenValueType = s[3];
        String givenValue = fields[1];

        return "Field " + fieldName + " must be of type " + requiredValue + "."
                + "Value of type " + givenValueType + " provided: " + givenValue + ".";
    }
}
