package br.com.fiap.Sprint4_2sem.service;

import br.com.fiap.Sprint4_2sem.model.Colaborador;
import br.com.fiap.Sprint4_2sem.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public List<Colaborador> findAll() {
        return colaboradorRepository.findAll();
    }

    public Optional<Colaborador> findById(Integer id) {
        return colaboradorRepository.findById(id);
    }

    public Colaborador save(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    public void deleteById(Integer id) {
        colaboradorRepository.deleteById(id);
    }

    public Colaborador update(Integer id, Colaborador model) {
        return null;
    }
}
