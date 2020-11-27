package com.codegym.repository.impl;

import com.codegym.entity.Product;
import com.codegym.repository.BaseRepository;
import com.codegym.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> getAllProduct() {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery( "select s from product s", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public Product findById(int id) {
//        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select s from product s where s.id = :id", Product.class);
//        TypedQuery<Product> typedQuery2 =
//                BaseRepository.entityManager.createQuery(
//                        "select s from product s where s.id = ?1", Product.class);
//        typedQuery2.setParameter(1, id);
//
//        return typedQuery.getSingleResult();
        return BaseRepository.entityManager.find(Product.class, id);

    }

    @Override
    public void edit(int id, Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findById(id));
        entityTransaction.commit();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }
}
