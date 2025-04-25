package com.github.RicardoNeto01.ms_pedido.entities;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "tb_item_do_pedido")
public class ItemDoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantidade;
    private String descricao;
    private BigDecimal valorUnitario;

}
