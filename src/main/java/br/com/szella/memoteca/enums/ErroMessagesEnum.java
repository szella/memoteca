package br.com.szella.memoteca.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErroMessagesEnum {
    ERRO_DB("Erro ao acessar BANCO"),
    ERRO_ENUM("Erro ao localizar referência");

    private final String description;

}