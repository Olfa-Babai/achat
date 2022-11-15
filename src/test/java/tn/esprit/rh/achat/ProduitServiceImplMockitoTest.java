package tn.esprit.rh.achat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mockito.Mock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.AchatApplication;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

@SpringBootTest(classes = AchatApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class ProduitServiceImplMockitoTest {
	 @Mock
	 ProduitRepository produitRepositoryMock;
	 @InjectMocks
	 ProduitServiceImpl produitService;
	 
	 
	 Produit op = Produit.builder().codeProduit("999").libelleProduit("Selma").prix(900f).build();
	 List<Produit> listOperateurs = new ArrayList<Produit>(){
	     {
	         add(Produit.builder().codeProduit("888").libelleProduit("Amira").prix(800f).build());
	         add(Produit.builder().codeProduit("666").libelleProduit("nour").prix(600f).build());
	         add(Produit.builder().codeProduit("522").libelleProduit("sab").prix(500f).build());
	         add(Produit.builder().codeProduit("1000").libelleProduit("yass").prix(1000f).build());

	     }

	 };
	 
	@Test
	public void testretrieveAllProduits() {
		 Mockito.when(produitRepositoryMock.findAll()).thenReturn(listOperateurs);
	     List<Produit> listOp = produitService.retrieveAllProduits();
	     Assertions.assertNotNull(listOp);
			System.out.println("woooorkiiiiing all retrieve !");


	}

	@Test
	public void testretrieveProduit() {
		Mockito.when(produitRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.of(op)); //find all
	    Produit op1 = produitService.retrieveProduit(2L);
	    Assertions.assertNotNull(op1);
		System.out.println("woooorkiiiiing retrieve !");
	}

	@Test
	public void testaddProduit() {
		 Mockito.when(produitRepositoryMock.save(op)).thenReturn(op);
		 Produit op1 = produitService.addProduit(op);
	     Assertions.assertNotNull(op1);
			System.out.println("woooorkiiiiing add !");

	}

	@Test
	public void testdeleteProduit() {
		Produit op2 = Produit.builder().codeProduit("999").libelleProduit("Selma").prix(900f).build();
	     produitService.deleteProduit(op2.getIdProduit());
	     Mockito.verify(produitRepositoryMock).deleteById(op2.getIdProduit());
			System.out.println("woooorkiiiiing delete !");

	}

	@Test
	public void testupdateProduit() {
		op.setLibelleProduit("khalil");
	     Mockito.when(produitRepositoryMock.save(op)).thenReturn(op);
	     Produit op1 = produitService.updateProduit(op);
	     Assertions.assertEquals(op.getLibelleProduit(),op1.getLibelleProduit());
			System.out.println("woooorkiiiiing update !");

	}
}