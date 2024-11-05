package br.com.fiap.Sprint4_2sem.dto;

import br.com.fiap.Sprint4_2sem.model.Empresa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmpresaDTO {

    private Long id;

    @NotBlank(message = "O campo nome é obrigatório.")
    @Size(max = 100, message = "O nome da empresa deve ter no máximo 100 caracteres.")
    private String nome;

    @NotBlank(message = "O campo CNPJ é obrigatório.")
    @Size(min = 14, max = 14, message = "O CNPJ deve ter exatamente 14 caracteres.")
    private String cnpj;

    @NotBlank(message = "O campo ramo de atuação é obrigatório.")
    private String ramoAtuacao;

    @NotNull(message = "O campo endereço é obrigatório.")
    private Long idEndereco;

    @NotNull(message = "O campo ramo empresa é obrigatório.")
    private Long idRamo;

    public Empresa toModel() {
        return null;
    }
}
