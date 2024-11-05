package br.com.fiap.Sprint4_2sem.controller;

import br.com.fiap.Sprint4_2sem.dto.FeedbackEmpresaDTO;
import br.com.fiap.Sprint4_2sem.exception.CustomException;
import br.com.fiap.Sprint4_2sem.model.FeedbackEmpresa;
import br.com.fiap.Sprint4_2sem.service.FeedbackEmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback-empresa")
public class FeedbackEmpresaController {

    @Autowired
    private FeedbackEmpresaService feedbackEmpresaService;

    @GetMapping
    public List<FeedbackEmpresa> findAll() {
        return feedbackEmpresaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackEmpresa> findById(@PathVariable Integer id) {
        return feedbackEmpresaService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new CustomException("Feedback da empresa não encontrado com ID: " + id));
    }

    @PostMapping
    public FeedbackEmpresa save(@Valid @RequestBody FeedbackEmpresaDTO feedbackEmpresaDTO) {
        return feedbackEmpresaService.save(feedbackEmpresaDTO.toModel());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedbackEmpresa> update(@PathVariable Integer id, @Valid @RequestBody FeedbackEmpresaDTO feedbackEmpresaDTO) {
        // Verifica se o feedback da empresa existe antes de atualizar
        if (!feedbackEmpresaService.findById(id).isPresent()) {
            throw new CustomException("Feedback da empresa não encontrado com ID: " + id);
        }
        return ResponseEntity.ok(feedbackEmpresaService.update(id, feedbackEmpresaDTO.toModel()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        // Verifica se o feedback da empresa existe antes de deletar
        if (!feedbackEmpresaService.findById(id).isPresent()) {
            throw new CustomException("Feedback da empresa não encontrado com ID: " + id);
        }
        feedbackEmpresaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
