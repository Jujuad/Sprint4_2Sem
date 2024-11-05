package br.com.fiap.Sprint4_2sem.controller;

import br.com.fiap.Sprint4_2sem.dto.UsuarioDTO;
import br.com.fiap.Sprint4_2sem.exception.CustomException;
import br.com.fiap.Sprint4_2sem.model.Usuario;
import br.com.fiap.Sprint4_2sem.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new CustomException(
                        messageSource.getMessage("user.not.found", null, Locale.getDefault())));
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.save(usuarioDTO.toModel());
        String successMessage = messageSource.getMessage("user.created", null, Locale.getDefault());
        return ResponseEntity.ok().header("Success-Message", successMessage).body(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        if (!usuarioService.findById(id).isPresent()) {
            throw new CustomException(
                    messageSource.getMessage("user.not.found", null, Locale.getDefault()));
        }
        Usuario updatedUsuario = usuarioService.update(id, usuarioDTO.toModel());
        String successMessage = messageSource.getMessage("user.updated", null, Locale.getDefault());
        return ResponseEntity.ok().header("Success-Message", successMessage).body(updatedUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!usuarioService.findById(id).isPresent()) {
            throw new CustomException(
                    messageSource.getMessage("user.not.found", null, Locale.getDefault()));
        }
        usuarioService.deleteById(id);
        String successMessage = messageSource.getMessage("user.deleted", null, Locale.getDefault());
        return ResponseEntity.noContent().header("Success-Message", successMessage).build();
    }
}
