package br.com.szella.memoteca.service.impl;

import br.com.szella.memoteca.enums.ErroMessagesEnum;
import br.com.szella.memoteca.exception.DBException;
import br.com.szella.memoteca.mapper.PensamentoMapper;
import br.com.szella.memoteca.model.entity.PensamentoEntity;
import br.com.szella.memoteca.model.request.PensamentoRequest;
import br.com.szella.memoteca.repository.PensamentoRepository;
import br.com.szella.memoteca.service.PensamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PensamentoServiceImpl implements PensamentoService {
    private final PensamentoRepository repository;

    @Override
    public List<PensamentoEntity> listar() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new DBException(ErroMessagesEnum.ERRO_DB);
        }
    }

    @Override
    public PensamentoEntity buscarPorId(Long id) {
        try {
            return Optional
                    .of(repository.findById(id))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .orElseThrow(() -> new DBException(ErroMessagesEnum.ERRO_DB));
        } catch (Exception e) {
            throw new DBException(ErroMessagesEnum.ERRO_DB);
        }
    }

    @Override
    public void criar(PensamentoRequest request) {
        try {
            var entity = PensamentoMapper.mapEntity(request);

            repository.save(entity);
        } catch (Exception e) {
            throw new DBException(ErroMessagesEnum.ERRO_DB);
        }
    }

    @Override
    public void editar(Long id, PensamentoRequest request) {
        try {
            var entity = buscarPorId(id);

            PensamentoMapper.mapUpdate(request, entity);

            repository.save(entity);
        } catch (Exception e) {
            throw new DBException(ErroMessagesEnum.ERRO_DB);
        }
    }

    @Override
    public void excluir(Long id) {
        try {
            repository.delete(buscarPorId(id));
        } catch (Exception e) {
            throw new DBException(ErroMessagesEnum.ERRO_DB);
        }
    }
}
