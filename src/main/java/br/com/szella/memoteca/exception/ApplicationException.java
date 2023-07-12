package br.com.szella.memoteca.exception;

import br.com.szella.memoteca.enums.ErroMessagesEnum;

public class ApplicationException extends RuntimeException {

    public ApplicationException(ErroMessagesEnum message) {
        super(message.getDescription());
    }
}
