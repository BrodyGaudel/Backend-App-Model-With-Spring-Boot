package com.brody.produits.restcontroller;

import com.brody.produits.entities.Categorie;
import com.brody.produits.services.CategorieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin("*")
public class CategorieRESTController {

    private final CategorieService categorieService;

    public CategorieRESTController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping
    @ResponseBody
    public List<Categorie> getAllCategories() {
        return categorieService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Categorie getCategorieById(@PathVariable("id") Long id) {
        return categorieService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public Categorie saveCategorie(@RequestBody Categorie categorie) {
        return categorieService.save(categorie);
    }



}
