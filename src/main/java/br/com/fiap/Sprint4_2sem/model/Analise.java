package br.com.fiap.Sprint4_2sem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "analise")
public class Analise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo resultados é obrigatório.")
    @Column(name = "resultados_analise")
    private String resultados;

    @NotNull(message = "A data da análise é obrigatória.")
    @Column(name = "data_analise")
    private LocalDate data;

    @NotNull(message = "O campo feedback é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "id_feedback_empresa")
    private FeedbackEmpresa feedbackEmpresa;
}
