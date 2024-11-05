package br.com.fiap.Sprint4_2sem.controller;

import br.com.fiap.Sprint4_2sem.dto.AnaliseDTO;
import br.com.fiap.Sprint4_2sem.exception.CustomException;
import br.com.fiap.Sprint4_2sem.model.Analise;
import br.com.fiap.Sprint4_2sem.service.AnaliseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analise")
public class AnaliseController {

    @Autowired
    private AnaliseService analiseService;

    @GetMapping
    public List<Analise> findAll() {
        return analiseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Analise> findById(@PathVariable Integer id) {
        return analiseService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new CustomException("Análise não encontrada com ID: " + id));
    }

    @PostMapping
    public Analise save(@Valid @RequestBody AnaliseDTO analiseDTO) {
        return analiseService.save(analiseDTO.toModel());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Analise> update(@PathVariable Integer id, @Valid @RequestBody AnaliseDTO analiseDTO) {
        // Verifica se a análise existe antes de atualizar
        if (!analiseService.findById(id).isPresent()) {
            throw new CustomException("Análise não encontrada com ID: " + id);
        }
        return ResponseEntity.ok(analiseService.update(id, analiseDTO.toModel()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        // Verifica se a análise existe antes de deletar
        if (!analiseService.findById(id).isPresent()) {
            throw new CustomException("Análise não encontrada com ID: " + id);
        }
        analiseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
