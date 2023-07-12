package br.com.szella.memoteca.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class PensamentoRequest {

    @NotBlank
    private String conteudo;

    @NotBlank
    private String autoria;

    @NotBlank
    private String modelo;
}
