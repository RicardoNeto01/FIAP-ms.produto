package com.github.RicardoNeto01.ms_pedido.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Entity
@Table(name = "tb_pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate data;
    @Enumerated(EnumType.STRING)
    private Status status;

    //relacionamento com ItemDoPedido
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST)
    private List<ItemDoPedido> itens = new ArrayList<>();
}
