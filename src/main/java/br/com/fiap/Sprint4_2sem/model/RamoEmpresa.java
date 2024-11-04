package br.com.fiap.Sprint4_2sem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "ramo_empresa")
public class RamoEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo nome do ramo é obrigatório.")
    @Size(max = 100, message = "O nome do ramo deve ter no máximo 100 caracteres.")
    @Column(name = "nome_ramo")
    private String nome;

    @NotBlank(message = "O campo descrição do ramo é obrigatório.")
    @Column(name = "desc_ramo")
    private String descricao;
}
