package br.com.szella.memoteca.mapper;

import br.com.szella.memoteca.enums.ModeloEnum;
import br.com.szella.memoteca.model.entity.PensamentoEntity;
import br.com.szella.memoteca.model.request.PensamentoRequest;
import br.com.szella.memoteca.model.response.PensamentoResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class PensamentoMapper {
    public static PensamentoEntity mapEntity(PensamentoRequest request) {
        return PensamentoEntity.builder()
                .conteudo(request.getConteudo())
                .autoria(request.getAutoria())
                .modeloEnum(ModeloEnum.getModelo(request.getModelo()))
                .build();
    }

    public static void mapUpdate(PensamentoRequest request, PensamentoEntity entity) {
        entity.setConteudo(request.getConteudo());
        entity.setAutoria(request.getAutoria());
        entity.setModeloEnum(ModeloEnum.getModelo(request.getModelo()));
    }

    public static PensamentoResponse mapResponse(PensamentoEntity entity) {
        return PensamentoResponse.builder()
                .id(entity.getId())
                .conteudo(entity.getConteudo())
                .autoria(entity.getAutoria())
                .modelo(entity.getModeloEnum().getDescription())
                .build();
    }

    public static List<PensamentoResponse> mapResponseList(List<PensamentoEntity> entities) {
        return entities.stream()
                .map(PensamentoMapper::mapResponse)
                .toList();
    }
}
