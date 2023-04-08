package com.brody.produits;

import com.brody.produits.entities.Categorie;
import com.brody.produits.entities.Produit;
import com.brody.produits.repositories.CategorieRepository;
import com.brody.produits.repositories.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class ProduitsApplicationTests {

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @Test
    void testCreateProduit() {
        Categorie categorie = categorieRepository.save(new Categorie(
                null, "PC PORTABLE", "i9, 2To, 64Go", null
        ));
        Produit prod = new Produit(null, "PC Dell",2200.500,new Date(), categorie);
        Produit p = produitRepository.save(prod);
        assertNotNull(p);
    }

    @Test
    void testFindProduit(){
        Produit p = produitRepository.findById(1L).orElse(null);
        assertNotNull(p);
        assertEquals(1L, p.getIdProduit());
        p.setCategorie(null);
        System.out.println(p);
    }

    @Test
    void testUpdateProduit() {
        Produit p = produitRepository.findById(1L).orElse(null);
        assertNotNull(p);
        p.setPrixProduit(1000.0);
        Produit prod = produitRepository.save(p);
        assertNotNull(prod);
    }

    @Test
    void testDeleteProduit()
    {
        produitRepository.deleteById(1L);
    }

    @Test
    void testListerTousProduits()
    {
        List<Produit> prods = produitRepository.findAll();
        for (Produit p : prods) {
            p.setCategorie(null);
            System.out.println(p);
        }
        assertNotNull(prods);
    }

    @Test
    void testFindByNomProduit()
    {
        List<Produit> prods = produitRepository.findByNomProduit("iphone X");
        for (Produit p : prods)
        {
            System.out.println(p);
        }
        assertNotNull(prods);
    }

    @Test
    void testFindByNomPrix()
    {
        List<Produit> prods = produitRepository.findByNomPrix("iphone X", 1000.0);
        for (Produit p : prods)
        {
            System.out.println(p);
        }
        assertNotNull(prods);
    }

    @Test
    void testFindByCategorie()
    {
        Categorie cat = new Categorie();
        cat.setIdCat(1L);
        List<Produit> prods = produitRepository.findByCategorie(cat);
        for (Produit p : prods)
        {
            System.out.println(p);
        }
        assertNotNull(prods);
    }

    @Test
    void testFindByCategorieIdCat()
    {
        List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
        for (Produit p : prods)
        {
            System.out.println(p);
        }
        assertNotNull(prods);
    }

    @Test
    void testFindByOrderByNomProduitAsc()
    {
        List<Produit> prods =
                produitRepository.findByOrderByNomProduitAsc();
        for (Produit p : prods)
        {
            System.out.println(p);
        }
        assertNotNull(prods);
    }

    @Test
    void testTrierProduitsNomsPrix()
    {
        List<Produit> prods = produitRepository.trierProduitsNomsPrix();
        for (Produit p : prods)
        {
            System.out.println(p);
        }
        assertNotNull(prods);
    }










}
