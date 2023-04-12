package com.brody.produits.services;

import com.brody.produits.entities.Categorie;

import java.util.List;

public interface CategorieService {
    Categorie findById(Long id);
    List<Categorie> findAll();
    Categorie save(Categorie categorie);
}
