package tn.esprit.rh.achat;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.*;
import tn.esprit.rh.achat.repositories.*;
import tn.esprit.rh.achat.services.*;

@RunWith(SpringRunner.class)
@Slf4j
@ExtendWith(MockitoExtension.class)

@MockitoSettings(strictness = Strictness.LENIENT)
public class TestSecteurActivite {
@Mock
    SecteurActiviteRepository Repo;
    @InjectMocks
    SecteurActiviteServiceImpl SecteurActiviteService;
    SecteurActivite o = new SecteurActivite("codeSecteurActivite","libelleSecteurActivite",null);
   
    @Test
    public void testAddSecteurActivite() {
        SecteurActivite op = new SecteurActivite("codeSecteurActivite","libelleSecteurActivite",null);
        Mockito.when(Repo.save(op)).thenReturn(op);
        SecteurActivite oTest = SecteurActiviteService.addSecteurActivite(op);
        Assertions.assertNotNull(oTest);
    }
   
    @Test
    public void testGetSecteurActivite() {
    Mockito.when(Repo.findAll()).thenReturn(Stream
    .of(new SecteurActivite("nom op1","prenom op1",null), new SecteurActivite("nom op2","prenom op2",null)).collect(Collectors.toList()));
    Assertions.assertEquals(2,SecteurActiviteService.retrieveAllSecteurActivite().size());
    }


    @Test
    public void testRetrieveSecteurActivite(){
    Mockito.when(Repo.findById(Mockito.anyLong())).thenReturn(Optional.of(o));
        SecteurActivite SecteurActiviteTest = SecteurActiviteService.retrieveSecteurActivite(o.getIdSecteurActivite());
   
    }
   
    @Test
    public void testRemoveSecteurActivite(){
    SecteurActiviteService.deleteSecteurActivite(o.getIdSecteurActivite());
        Mockito.verify(Repo, Mockito.times(1)).deleteById(o.getIdSecteurActivite());
    }
   
    @Test
    public void testModifySecteurActivite(){
    o.setCodeSecteurActivite("nom updated");
         Mockito.when(Repo.save(o)).thenReturn(o);
         SecteurActivite oTest = SecteurActiviteService.updateSecteurActivite(o);
         Assertions.assertEquals(o,oTest);
    }
   

}
