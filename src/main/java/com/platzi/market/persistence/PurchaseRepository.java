package com.platzi.market.persistence;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repository.IPurchaseRepository;
import com.platzi.market.persistence.crud.PurchaseCrudRepository;
import com.platzi.market.persistence.entity.PurchaseEntity;
import com.platzi.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements IPurchaseRepository {

    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getAll() {
        List<PurchaseEntity> purchaseEntities = (List<PurchaseEntity>) purchaseCrudRepository.findAll();
        List<Purchase> purchases = purchaseMapper.toPurchases(purchaseEntities);
        return purchases;
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return purchaseCrudRepository.findByIdCliente(clientId)
                .map(compras -> purchaseMapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        PurchaseEntity purchaseEntity = purchaseMapper.toPurchaseEntity(purchase);
        purchaseEntity.getPurchaseItemEntities().forEach(producto -> producto.setPurchaseEntity(purchaseEntity));
        return purchaseMapper.toPurchase(purchaseCrudRepository.save(purchaseEntity));
    }
}
