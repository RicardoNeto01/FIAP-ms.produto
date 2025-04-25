package com.github.RicardoNeto01.ms_pedido.Dto;

import com.github.RicardoNeto01.ms_pedido.entities.ItemDoPedido;
import com.github.RicardoNeto01.ms_pedido.entities.Pedido;
import com.github.RicardoNeto01.ms_pedido.entities.Status;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PedidoDTO {

    private Long id;
    @NotEmpty(message = "Nome requerido")
    @Size(min = 3, max = 100, message = "O nome deve ser entre 3 e 100 caracteres.")
    private String nome;
    @NotEmpty(message = "Cpf requerido.")
    @Size(min = 11, max = 11, message = "O cpf deve ter entre 11 e 14 caracteres.")
    private String cpf;
    private LocalDate data;
    private Status status;
    private List<@Valid ItemDoPedidoDTO> itens = new ArrayList<>();

    public PedidoDTO(Pedido entity) {
        id = entity.getId();
        nome = entity.getNome();
        cpf = entity.getCpf();
        data = entity.getData();
        status = entity.getStatus();

        for (ItemDoPedido item : entity.getItens()){
            ItemDoPedidoDTO dto = new ItemDoPedidoDTO(item);
            itens.add(dto);
        }
    }
}
