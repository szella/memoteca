package br.com.szella.memoteca.service;

import br.com.szella.memoteca.model.entity.PensamentoEntity;
import br.com.szella.memoteca.model.request.PensamentoRequest;

import java.util.List;

public interface PensamentoService {

    List<PensamentoEntity> listar();

    PensamentoEntity buscarPorId(Long id);

    void criar(PensamentoRequest request);

    void editar(Long id, PensamentoRequest request);

    void excluir(Long id);
}
