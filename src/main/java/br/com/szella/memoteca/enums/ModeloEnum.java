package br.com.szella.memoteca.enums;

import br.com.szella.memoteca.exception.DBException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum ModeloEnum {
    MODELO_1("modelo1"),
    MODELO_2("modelo2"),
    MODELO_3("modelo3");

    private final String description;

    public static ModeloEnum getModelo(String description) {
        return Arrays.stream(ModeloEnum.values())
                .filter(modeloEnum -> modeloEnum.getDescription().equals(description))
                .findFirst()
                .orElseThrow(() -> new DBException(ErroMessagesEnum.ERRO_DB));
    }
}
