package br.com.fiap.Sprint4_2sem.controller;

import br.com.fiap.Sprint4_2sem.dto.RamoEmpresaDTO;
import br.com.fiap.Sprint4_2sem.model.RamoEmpresa;
import br.com.fiap.Sprint4_2sem.service.RamoEmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ramo-empresa")
public class RamoEmpresaController {

    @Autowired
    private RamoEmpresaService ramoEmpresaService;

    @GetMapping
    public List<RamoEmpresa> findAll() {
        return ramoEmpresaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RamoEmpresa> findById(@PathVariable Integer id) {
        return ramoEmpresaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RamoEmpresa save(@Valid @RequestBody RamoEmpresaDTO ramoEmpresaDTO) {
        return ramoEmpresaService.save(ramoEmpresaDTO.toModel());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RamoEmpresa> update(@PathVariable Integer id, @Valid @RequestBody RamoEmpresaDTO ramoEmpresaDTO) {
        return ResponseEntity.ok(ramoEmpresaService.update(id, ramoEmpresaDTO.toModel()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        ramoEmpresaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
