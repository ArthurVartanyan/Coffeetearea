package ru.coffeetearea.dto;

import lombok.Data;
//import ru.coffeetearea.model.Address;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderDTO {

    public interface MakeOrder {

    }

    @Null(groups = {OrderDTO.MakeOrder.class})
    private Long id;

    @NotNull(groups = {OrderDTO.MakeOrder.class})
//    @Size(min = 10, groups = {OrderDTO.MakeOrder.class})
//    private Address address;

    @NotNull(groups = {OrderDTO.MakeOrder.class})
    @Size(min = 11, max = 11, groups = {OrderDTO.MakeOrder.class})
    private String phoneNumber;

    @Null(groups = {OrderDTO.MakeOrder.class})
    private Date dateOrder;

    @Null(groups = {OrderDTO.MakeOrder.class})
    private BigDecimal totalCost;
}