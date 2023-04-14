package com.brody.produits.restcontroller;

import com.brody.produits.entities.Produit;
import com.brody.produits.services.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRESTController {

    private final ProduitService produitService;


    public ProduitRESTController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/getbyid/{id}")
    @ResponseBody
    public Produit getProduitById(@PathVariable("id") Long id) {
        return produitService.getProduit(id);
    }

    @PostMapping("/addprod")
    @ResponseBody
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }

    @PutMapping("/updateprod")
    @ResponseBody
    public Produit updateProduit(@RequestBody Produit produit) {
        return produitService.updateProduit(produit);
    }

    @DeleteMapping("/delprod/{id}")
    public void deleteProduit(@PathVariable("id") Long id) {
        produitService.deleteProduitById(id);
    }

    @GetMapping("/prodscat/{idCat}")
    @ResponseBody
    public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
        return produitService.findByCategorieIdCat(idCat);
    }

}
