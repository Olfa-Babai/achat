package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.converters.ProduitConverter;
import tn.esprit.rh.achat.dtos.ProduitDTO;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;

import java.util.List;


@RestController
//@CrossOrigin("*")
@Api(tags = "Gestion des produits")
@RequestMapping("/produit")
public class ProduitRestController {

	@Autowired
	IProduitService produitService;

	@Autowired
	ProduitConverter produitConverter;

	// http://localhost:8089/SpringMVC/produit/retrieve-all-produits
	@GetMapping("/retrieve-all-produits")
	@ResponseBody
	public List<Produit> getProduits() {
		return produitService.retrieveAllProduits();
	}

	// http://localhost:8089/SpringMVC/produit/retrieve-produit/8
	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public Produit retrieveRayon(@PathVariable("produit-id") Long produitId) {
		return produitService.retrieveProduit(produitId);
	}

	// http://localhost:8089/SpringMVC/produit/add-produit/1/1
	@PostMapping("/add-produit")
	@ResponseBody
	public Produit addProduit(@RequestBody ProduitDTO p) {

		Produit produit = produitConverter.dtoToEntity(p);
		return produitService.addProduit(produit);
	}

	// http://localhost:8089/SpringMVC/produit/remove-produit/1
	@DeleteMapping("/remove-produit/{produit-id}")
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long produitId) {
		produitService.deleteProduit(produitId);
	}

	// http://localhost:8089/SpringMVC/produit/modify-produit/1/1
	@PutMapping("/modify-produit")
	@ResponseBody
	public Produit modifyProduit(@RequestBody ProduitDTO p) {
		Produit produit=produitConverter.dtoToEntity(p);
		return produitService.updateProduit(produit);
	}

	// http://localhost:8089/SpringMVC/produit/assignProduitToStock/1/5
	@PutMapping(value = "/assignProduitToStock/{idProduit}/{idStock}")
	public void assignProduitToStock(@PathVariable("idProduit") Long idProduit, @PathVariable("idStock") Long idStock) {
		produitService.assignProduitToStock(idProduit, idStock);
	}
}
