package br.com.fiap.Sprint4_2sem.controller;

import br.com.fiap.Sprint4_2sem.dto.EmpresaDTO;
import br.com.fiap.Sprint4_2sem.exception.CustomException;
import br.com.fiap.Sprint4_2sem.model.Empresa;
import br.com.fiap.Sprint4_2sem.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<Empresa> findAll() {
        return empresaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> findById(@PathVariable Integer id) {
        return empresaService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new CustomException("Empresa não encontrada com ID: " + id));
    }

    @PostMapping
    public Empresa save(@Valid @RequestBody EmpresaDTO empresaDTO) {
        return empresaService.save(empresaDTO.toModel());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> update(@PathVariable Integer id, @Valid @RequestBody EmpresaDTO empresaDTO) {
        // Verifica se a empresa existe antes de atualizar
        if (!empresaService.findById(id).isPresent()) {
            throw new CustomException("Empresa não encontrada com ID: " + id);
        }
        return ResponseEntity.ok(empresaService.update(id, empresaDTO.toModel()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        // Verifica se a empresa existe antes de deletar
        if (!empresaService.findById(id).isPresent()) {
            throw new CustomException("Empresa não encontrada com ID: " + id);
        }
        empresaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
