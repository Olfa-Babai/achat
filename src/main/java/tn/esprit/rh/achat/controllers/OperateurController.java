package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.converters.OperateurConverter;
import tn.esprit.rh.achat.dtos.OperateurDTO;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.services.IOperateurService;

import java.util.List;

@RestController
@Api(tags = "Gestion des opérateurs")
@RequestMapping("/operateur")
//@CrossOrigin("*")
public class OperateurController {

	@Autowired
	IOperateurService operateurService;

	@Autowired
	OperateurConverter operateurConverter;
	
	// http://localhost:8089/SpringMVC/operateur/retrieve-all-operateurs
	@GetMapping("/retrieve-all-operateurs")
	@ResponseBody
	public List<Operateur> getOperateurs() {
		return operateurService.retrieveAllOperateurs();
	}

	// http://localhost:8089/SpringMVC/operateur/retrieve-operateur/8
	@GetMapping("/retrieve-operateur/{operateur-id}")
	@ResponseBody
	public Operateur retrieveOperateur(@PathVariable("operateur-id") Long operateurId) {
		return operateurService.retrieveOperateur(operateurId);
	}

	// http://localhost:8089/SpringMVC/operateur/add-operateur
	@PostMapping("/add-operateur")
	@ResponseBody
	public Operateur addOperateur(@RequestBody OperateurDTO op) {
		Operateur o=operateurConverter.dtoToEntity(op);
		return operateurService.addOperateur(o);
	}

	// http://localhost:8089/SpringMVC/operateur/remove-operateur/{operateur-id}
	@DeleteMapping("/remove-operateur/{operateur-id}")
	@ResponseBody
	public void removeOperateur(@PathVariable("operateur-id") Long operateurId) {
		operateurService.deleteOperateur(operateurId);
	}

	// http://localhost:8089/SpringMVC/operateur/modify-operateur
	@PutMapping("/modify-operateur")
	@ResponseBody
	public Operateur modifyOperateur(@RequestBody OperateurDTO operateur) {
		Operateur o=operateurConverter.dtoToEntity(operateur);
		return operateurService.updateOperateur(o);
	}

	
}
