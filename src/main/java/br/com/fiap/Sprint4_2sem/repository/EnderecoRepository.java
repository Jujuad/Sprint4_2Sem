package br.com.fiap.Sprint4_2sem.repository;

import br.com.fiap.Sprint4_2sem.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
