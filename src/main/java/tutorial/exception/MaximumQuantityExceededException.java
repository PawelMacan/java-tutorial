package tutorial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MaximumQuantityExceededException extends Throwable {

    public MaximumQuantityExceededException(int quantity){
        super ( String.format( "Quantity %dexceeds maximum quantity allowed: 10.", quantity ) );
    }

}

