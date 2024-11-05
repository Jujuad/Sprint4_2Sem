package br.com.fiap.Sprint4_2sem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "endereco_empresa")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo CEP é obrigatório.")
    @Size(min = 8, max = 8, message = "O CEP deve ter exatamente 8 caracteres.")
    @Column(name = "cep_endereco", length = 8)
    private String cep;

    @NotBlank(message = "O campo rua é obrigatório.")
    @Column(name = "rua_endereco")
    private String rua;

    @NotBlank(message = "O campo número é obrigatório.")
    @Column(name = "num_endereco")
    private Integer numero;

    @NotBlank(message = "O campo bairro é obrigatório.")
    @Column(name = "bairro_endereco")
    private String bairro;

    @NotBlank(message = "O campo cidade é obrigatório.")
    @Column(name = "cidade_endereco")
    private String cidade;

    @NotBlank(message = "O campo estado é obrigatório.")
    @Column(name = "estado_endereco")
    private String estado;

    @NotBlank(message = "O campo UF é obrigatório.")
    @Size(min = 2, max = 2, message = "O campo UF deve ter exatamente 2 caracteres.")
    @Column(name = "uf_endereco", length = 2)
    private String uf;

    @NotBlank(message = "O campo país é obrigatório.")
    @Column(name = "pais_endereco")
    private String pais;

    public void setIdEndereco(Integer id) {
    }
}

