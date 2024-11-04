package br.com.fiap.Sprint4_2sem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AnaliseDTO {

    private Long id;

    @NotBlank(message = "O campo resultados é obrigatório.")
    private String resultados;

    @NotNull(message = "A data da análise é obrigatória.")
    private LocalDate data;

    @NotNull(message = "O campo feedback é obrigatório.")
    private Long idFeedbackEmpresa;
}
