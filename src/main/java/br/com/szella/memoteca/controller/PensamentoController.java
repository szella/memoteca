package br.com.szella.memoteca.controller;

import br.com.szella.memoteca.mapper.PensamentoMapper;
import br.com.szella.memoteca.model.request.PensamentoRequest;
import br.com.szella.memoteca.model.response.PensamentoResponse;
import br.com.szella.memoteca.service.PensamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pensamentos")
@CrossOrigin(origins = {"http://localhost:4200/"})
@RequiredArgsConstructor
public class PensamentoController {

    private final PensamentoService service;

    @GetMapping
    public ResponseEntity<List<PensamentoResponse>> listar() {
        var entities = service.listar();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(PensamentoMapper.mapResponseList(entities));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PensamentoResponse> buscarPorId(@PathVariable Long id) {
        var entity = service.buscarPorId(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(PensamentoMapper.mapResponse(entity));
    }

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody @Valid PensamentoRequest request) {
        service.criar(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> editar(@PathVariable Long id, @RequestBody @Valid PensamentoRequest request) {
        service.editar(id, request);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
