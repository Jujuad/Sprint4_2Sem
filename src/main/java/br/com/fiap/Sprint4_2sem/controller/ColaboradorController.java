package br.com.fiap.Sprint4_2sem.controller;

import br.com.fiap.Sprint4_2sem.dto.ColaboradorDTO;
import br.com.fiap.Sprint4_2sem.exception.CustomException;
import br.com.fiap.Sprint4_2sem.model.Colaborador;
import br.com.fiap.Sprint4_2sem.service.ColaboradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colaborador")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    public List<Colaborador> findAll() {
        return colaboradorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> findById(@PathVariable Integer id) {
        return colaboradorService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new CustomException("Colaborador não encontrado com ID: " + id));
    }

    @PostMapping
    public Colaborador save(@Valid @RequestBody ColaboradorDTO colaboradorDTO) {
        return colaboradorService.save(colaboradorDTO.toModel());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> update(@PathVariable Integer id, @Valid @RequestBody ColaboradorDTO colaboradorDTO) {
        // Verifica se o colaborador existe antes de atualizar
        if (!colaboradorService.findById(id).isPresent()) {
            throw new CustomException("Colaborador não encontrado com ID: " + id);
        }
        return ResponseEntity.ok(colaboradorService.update(id, colaboradorDTO.toModel()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        // Verifica se o colaborador existe antes de deletar
        if (!colaboradorService.findById(id).isPresent()) {
            throw new CustomException("Colaborador não encontrado com ID: " + id);
        }
        colaboradorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
