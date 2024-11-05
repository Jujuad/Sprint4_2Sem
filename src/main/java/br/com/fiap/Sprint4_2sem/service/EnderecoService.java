package br.com.fiap.Sprint4_2sem.service;

import br.com.fiap.Sprint4_2sem.model.Endereco;
import br.com.fiap.Sprint4_2sem.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> findById(Integer id) {
        return enderecoRepository.findById(id);
    }

    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public void deleteById(Integer id) {
        enderecoRepository.deleteById(id);
    }

    public Endereco update(Integer id, Endereco model) {
        // Verifica se o endereço existe
        if (!enderecoRepository.existsById(id)) {
            throw new RuntimeException("Endereço com ID " + id + " não encontrado");
        }

        // Define o ID do modelo que será atualizado
        model.setIdEndereco(id);  // Ajuste se o nome do método setter for diferente
        return enderecoRepository.save(model);
    }
}
