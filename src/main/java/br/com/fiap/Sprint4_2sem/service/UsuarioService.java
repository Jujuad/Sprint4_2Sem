package br.com.fiap.Sprint4_2sem.service;

import br.com.fiap.Sprint4_2sem.model.Usuario;
import br.com.fiap.Sprint4_2sem.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        // Adicione aqui validações antes de salvar, se necessário
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Integer id) {
        // Verifica se o usuário existe antes de tentar deletar
        if (!usuarioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário com ID " + id + " não encontrado");
        }
        usuarioRepository.deleteById(id);
    }

    public Usuario update(Integer id, Usuario model) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário com ID " + id + " não encontrado");
        }

        model.setIdUsuario(id);
        return usuarioRepository.save(model);
    }
}
