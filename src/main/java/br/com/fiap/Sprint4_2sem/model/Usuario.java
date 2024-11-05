package br.com.fiap.Sprint4_2sem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo nome é obrigatório.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    @Column(name = "nome_usuario")
    private String nome;

    @NotBlank(message = "O campo e-mail é obrigatório.")
    @Email(message = "O e-mail deve ser válido.")
    @Column(name = "email_corporativo_usuario")
    private String email;

    @NotBlank(message = "O campo senha é obrigatório.")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.")
    @Column(name = "senha_usuario")
    private String senha;

    public void setIdUsuario(Integer id) {

    }
}
