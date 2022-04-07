package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Purchase;
import com.platzi.market.persistence.entity.PurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
        @Mapping(source = "idCompra", target = "purcharseId"),
        @Mapping(source = "idCliente", target = "clientId"),
        @Mapping(source = "fecha", target = "date"),
        @Mapping(source = "medioPago", target = "paymentMethod"),
        @Mapping(source = "comentario", target = "comment"),
        @Mapping(source = "estado", target = "state"),
        @Mapping(source = "purchaseItemEntities", target = "items")
    })
    Purchase toPurchase(PurchaseEntity purchaseEntity);
    List<Purchase> toPurchases(List<PurchaseEntity> purchaseEntities);

    @InheritInverseConfiguration
    @Mapping(target = "clientEntity", ignore = true)
    PurchaseEntity toPurchaseEntity(Purchase purchase);

}
