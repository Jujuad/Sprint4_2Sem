package br.com.fiap.Sprint4_2sem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo nome é obrigatório.")
    @Size(max = 100, message = "O nome da empresa deve ter no máximo 100 caracteres.")
    @Column(name = "nome_empresa")
    private String nome;

    @NotBlank(message = "O campo CNPJ é obrigatório.")
    @Size(min = 14, max = 14, message = "O CNPJ deve ter exatamente 14 caracteres.")
    @Column(name = "cnpj_empresa", length = 14)
    private String cnpj;

    @NotBlank(message = "O campo ramo de atuação é obrigatório.")
    @Column(name = "ramo_atuacao_empresa")
    private String ramoAtuacao;

    @NotNull(message = "O campo endereço é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @NotNull(message = "O campo ramo empresa é obrigatório.")
    @Column(name = "id_ramo_empresa")
    private Long idRamo;
}
