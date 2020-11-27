package com.example.demo.controller;
import java.util.logging.Logger;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Produit;
import com.example.demo.repository.ProduitRepository;

@Controller
@RequestMapping("/produits/")
public class ProduitController {
	
	@Autowired
	private ProduitRepository produitrepository;
	
	@GetMapping("list") 
	public String home(Model model) {
		
		List<Produit> prds = produitrepository.findAll();
		model.addAttribute("listproduits", prds);
		
		return "index";
	}
	
	
	@GetMapping("ajout")
	public String affiche(Model model) {
		model.addAttribute("produit",new Produit());
		return "afficheform";
	}
	
	@PostMapping("add")
	public String add(@Validated Produit produit, BindingResult result,Model model) {
		if(result.hasErrors())
			return "afficheform";
		else{
			produitrepository.save(produit);
			return "redirect:list";
		}
	}

	@GetMapping("delete/{id}")
	public String destroy(@PathVariable Long id) {
				//Produit p=produitrepository.findById(id);
			produitrepository.deleteById(id);
			return "redirect:/produits/list";

	}

    @GetMapping("modifier/{id}")
    public String update(Model model,@PathVariable Long id) {
           Produit p= produitrepository.getOne(id);
            model.addAttribute("produit",p);
            return "modifierProduit";
    }

    @PostMapping("modifier/update/{id}")
    public String edit(Model model,@Validated Produit produit) {
        produitrepository.save(produit);
        return "redirect:/produits/list";
    }
}
