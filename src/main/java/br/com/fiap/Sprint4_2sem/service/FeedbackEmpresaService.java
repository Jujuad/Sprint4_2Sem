package br.com.fiap.Sprint4_2sem.service;

import br.com.fiap.Sprint4_2sem.model.FeedbackEmpresa;
import br.com.fiap.Sprint4_2sem.repository.FeedbackEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackEmpresaService {

    @Autowired
    private FeedbackEmpresaRepository feedbackEmpresaRepository;

    public List<FeedbackEmpresa> findAll() {
        return feedbackEmpresaRepository.findAll();
    }

    public Optional<FeedbackEmpresa> findById(Integer id) {
        return feedbackEmpresaRepository.findById(id);
    }

    public FeedbackEmpresa save(FeedbackEmpresa feedbackEmpresa) {
        return feedbackEmpresaRepository.save(feedbackEmpresa);
    }

    public void deleteById(Integer id) {
        feedbackEmpresaRepository.deleteById(id);
    }

    public FeedbackEmpresa update(Integer id, FeedbackEmpresa model) {

        if (!feedbackEmpresaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Feedback com ID " + id + " não encontrado");
        }

        model.setIdFeedback(id);
        return feedbackEmpresaRepository.save(model);
    }
}
