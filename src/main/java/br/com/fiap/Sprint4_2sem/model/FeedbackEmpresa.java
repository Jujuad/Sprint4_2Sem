package br.com.fiap.Sprint4_2sem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "feedback_empresa")
public class FeedbackEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O campo usuário é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @NotNull(message = "O campo empresa é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public void setIdFeedback(Integer id) {

    }
}

