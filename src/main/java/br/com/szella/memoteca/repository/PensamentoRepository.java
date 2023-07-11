package br.com.szella.memoteca.repository;

import br.com.szella.memoteca.model.entity.PensamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PensamentoRepository extends JpaRepository<PensamentoEntity, Long> {
}
