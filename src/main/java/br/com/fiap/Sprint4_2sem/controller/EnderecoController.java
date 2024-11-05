package br.com.fiap.Sprint4_2sem.controller;

import br.com.fiap.Sprint4_2sem.dto.EnderecoDTO;
import br.com.fiap.Sprint4_2sem.model.Endereco;
import br.com.fiap.Sprint4_2sem.model.Endereco;
import br.com.fiap.Sprint4_2sem.service.EnderecoService;
import br.com.fiap.Sprint4_2sem.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endereco-empresa")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> findAll() {
        return enderecoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Integer id) {
        return enderecoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Endereco save(@Valid @RequestBody EnderecoDTO enderecoEmpresaDTO) {
        return enderecoService.save(enderecoEmpresaDTO.toModel());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> update(@PathVariable Integer id, @Valid @RequestBody EnderecoDTO enderecoEmpresaDTO) {
        return ResponseEntity.ok(enderecoService.update(id, enderecoEmpresaDTO.toModel()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        enderecoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
