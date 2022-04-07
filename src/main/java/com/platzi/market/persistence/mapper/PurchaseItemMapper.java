package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.PurchaseItem;
import com.platzi.market.persistence.entity.PurchaseItemEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            // Se omite total porque se llaman igual
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(PurchaseItemEntity purchaseItemEntity);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id.idCompra", ignore = true),
            @Mapping(target = "purchaseEntity", ignore = true),
            @Mapping(target = "productEntity", ignore = true)
    })
    PurchaseItemEntity toPurchaseItemEntity(PurchaseItem purchaseItem);

}
