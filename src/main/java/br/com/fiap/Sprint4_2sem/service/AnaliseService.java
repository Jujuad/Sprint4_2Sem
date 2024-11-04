package br.com.fiap.Sprint4_2sem.service;

import br.com.fiap.Sprint4_2sem.model.Analise;
import br.com.fiap.Sprint4_2sem.repository.AnaliseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnaliseService {

    @Autowired
    private AnaliseRepository analiseRepository;

    public List<Analise> findAll() {
        return analiseRepository.findAll();
    }

    public Optional<Analise> findById(Integer id) {
        return analiseRepository.findById(id);
    }

    public Analise save(Analise analise) {
        return analiseRepository.save(analise);
    }

    public void deleteById(Integer id) {
        analiseRepository.deleteById(id);
    }
}
