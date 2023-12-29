package org.pierre.shareazade;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ShareException extends Exception {
    public ShareException(String message) {
        super(message);
    }

}
