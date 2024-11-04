package br.com.fiap.Sprint4_2sem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RamoEmpresaDTO {

    private Long id;

    @NotBlank(message = "O campo nome do ramo é obrigatório.")
    @Size(max = 100, message = "O nome do ramo deve ter no máximo 100 caracteres.")
    private String nome;

    @NotBlank(message = "O campo descrição do ramo é obrigatório.")
    private String descricao;
}
