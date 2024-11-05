package br.com.fiap.Sprint4_2sem.service;

import br.com.fiap.Sprint4_2sem.exception.CustomException;
import br.com.fiap.Sprint4_2sem.model.RamoEmpresa;
import br.com.fiap.Sprint4_2sem.repository.RamoEmpresaRepository; // Supondo que haja um repositório
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RamoEmpresaService {

    @Autowired
    private RamoEmpresaRepository ramoEmpresaRepository; // Injetando o repositório

    public List<RamoEmpresa> findAll() {
        return ramoEmpresaRepository.findAll(); // Método que busca todos os registros
    }

    public Optional<RamoEmpresa> findById(Integer id) {
        return ramoEmpresaRepository.findById(id); // Busca por ID
    }

    public RamoEmpresa save(RamoEmpresa ramoEmpresa) {
        return ramoEmpresaRepository.save(ramoEmpresa); // Salva um novo registro
    }

    public RamoEmpresa update(Integer id, RamoEmpresa ramoEmpresa) {
        if (!ramoEmpresaRepository.existsById(id)) { // Verifica se o registro existe
            throw new CustomException("Ramo da empresa não encontrado com ID: " + id);
        }
        ramoEmpresa.setId(Long.valueOf(id)); // Define o ID do objeto a ser atualizado
        return ramoEmpresaRepository.save(ramoEmpresa); // Atualiza o registro
    }

    public void deleteById(Integer id) {
        if (!ramoEmpresaRepository.existsById(id)) { // Verifica se o registro existe antes de deletar
            throw new CustomException("Ramo da empresa não encontrado com ID: " + id);
        }
        ramoEmpresaRepository.deleteById(id); // Deleta o registro
    }
}
