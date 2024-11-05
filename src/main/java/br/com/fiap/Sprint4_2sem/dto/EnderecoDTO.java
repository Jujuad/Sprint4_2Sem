package br.com.fiap.Sprint4_2sem.dto;

import br.com.fiap.Sprint4_2sem.model.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EnderecoDTO {

    private Long id;

    @NotBlank(message = "O campo CEP é obrigatório.")
    @Size(min = 8, max = 8, message = "O CEP deve ter exatamente 8 caracteres.")
    private String cep;

    @NotBlank(message = "O campo rua é obrigatório.")
    private String rua;

    @NotBlank(message = "O campo número é obrigatório.")
    private Integer numero;

    @NotBlank(message = "O campo bairro é obrigatório.")
    private String bairro;

    @NotBlank(message = "O campo cidade é obrigatório.")
    private String cidade;

    @NotBlank(message = "O campo estado é obrigatório.")
    private String estado;

    @NotBlank(message = "O campo UF é obrigatório.")
    @Size(min = 2, max = 2, message = "O campo UF deve ter exatamente 2 caracteres.")
    private String uf;

    @NotBlank(message = "O campo país é obrigatório.")
    private String pais;

    public Endereco toModel() {
        Endereco endereco = new Endereco();
        endereco.setId(this.id);
        endereco.setCep(this.cep);
        endereco.setRua(this.rua);
        endereco.setNumero(this.numero);
        endereco.setBairro(this.bairro);
        endereco.setCidade(this.cidade);
        endereco.setEstado(this.estado);
        endereco.setUf(this.uf);
        endereco.setPais(this.pais);
        return endereco;
    }
}
