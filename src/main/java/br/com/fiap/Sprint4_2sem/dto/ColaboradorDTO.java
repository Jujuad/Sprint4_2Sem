package br.com.fiap.Sprint4_2sem.dto;

import br.com.fiap.Sprint4_2sem.model.Colaborador;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ColaboradorDTO {

    private Long id;

    @NotNull(message = "O campo usuário é obrigatório.")
    private Long idUsuario;

    @NotNull(message = "O campo empresa é obrigatório.")
    private Long idEmpresa;

    public Colaborador toModel() {
        return null;
    }
}
