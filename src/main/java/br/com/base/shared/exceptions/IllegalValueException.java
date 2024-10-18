package br.com.base.shared.exceptions;

import java.io.Serial;

public class IllegalValueException extends BusinessException {

    @Serial
    private static final long serialVersionUID = 1L;

    public IllegalValueException(String message) {
        super(message);
    }
}
