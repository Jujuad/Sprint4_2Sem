package br.com.fiap.Sprint4_2sem.service;

import br.com.fiap.Sprint4_2sem.model.RamoEmpresa;
import br.com.fiap.Sprint4_2sem.repository.RamoEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RamoEmpresaService {

    @Autowired
    private RamoEmpresaRepository ramoEmpresaRepository;

    public List<RamoEmpresa> findAll() {
        return ramoEmpresaRepository.findAll();
    }

    public Optional<RamoEmpresa> findById(Integer id) {
        return ramoEmpresaRepository.findById(id);
    }

    public RamoEmpresa save(RamoEmpresa ramoEmpresa) {
        return ramoEmpresaRepository.save(ramoEmpresa);
    }

    public void deleteById(Integer id) {
        ramoEmpresaRepository.deleteById(id);
    }
}
