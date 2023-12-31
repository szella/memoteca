package br.com.szella.memoteca.exception;

import br.com.szella.memoteca.enums.ErroMessagesEnum;

public class DBException extends RuntimeException {

    public DBException(ErroMessagesEnum message) {
        super(message.getDescription());
    }
}
