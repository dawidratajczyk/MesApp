package MesAplication.resControler;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import MesAplication.resControler.entities.dane;
import MesAplication.resControler.entities.dane.materialOnly;
import MesAplication.resControler.entities.dane.wartoscstandardowa2Only;

public interface crudControlerDlaDanych extends JpaRepository<dane,Long> {
	
	List<dane> findByMaterial(String material);
	

	
	Collection<materialOnly> findDistinctByMaterialLike(String material);
	
	Collection<wartoscstandardowa2Only> findByMaterialAndOperacja(String material,String operacja);

}
