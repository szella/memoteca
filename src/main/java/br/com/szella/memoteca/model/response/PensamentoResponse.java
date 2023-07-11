package br.com.szella.memoteca.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PensamentoResponse {
    private Long id;
    private String conteudo;
    private String autoria;
    private String modelo;
}
