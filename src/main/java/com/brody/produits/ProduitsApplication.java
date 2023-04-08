package com.brody.produits;

import com.brody.produits.entities.Produit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ProduitsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduitsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(RepositoryRestConfiguration repositoryRestConfiguration){
        return args -> repositoryRestConfiguration.exposeIdsFor(Produit.class);
    }

}
