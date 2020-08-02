package MesAplication.resControler;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import MesAplication.resControler.entities.dane;
import MesAplication.resControler.entities.maszyny;
import MesAplication.resControler.entities.dane.materialOnly;
import MesAplication.resControler.entities.dane.wartoscstandardowa2Only;
import MesAplication.resControler.entities.produkcja;


@Controller
public class ContrMarszruta {
@Autowired
crudControlerDlaDanych crudData;

@Autowired
crudControlerDlaMaszyn crudMachine;

@Autowired
crudControlerDlaProdukcji crud;

@CrossOrigin
@GetMapping("/addrecord")
public String addrec(Map<String,Object> model) {
	produkcja produkcja = new produkcja();
	List<maszyny> listaMaszyn = crudMachine.findAll();	
	
	
	model.put("zapis", produkcja);
	model.put("maszyny", listaMaszyn);
	return "newDataEntry";
}

@CrossOrigin
@ResponseBody
@GetMapping("/findrecord")
public Collection<materialOnly> findedData(@RequestParam String mat){
	String material = "%"+mat+"%";
	System.out.println(mat);
	
	Collection<materialOnly> dane = crudData.findDistinctByMaterialLike(material);
	return dane;
	
}

@CrossOrigin
@ResponseBody
@GetMapping("/findoperation")
public List<dane> findoperation(@RequestParam String mat){
	String material = mat;
	System.out.println(mat);
	
	List<dane> dane = crudData.findByMaterial(material);
	return dane;
	
}


@CrossOrigin
@ResponseBody
@GetMapping("/findtime")
public Collection<wartoscstandardowa2Only> findtime(@RequestParam String mat, @RequestParam String op ){
	String material = mat;
	String operacja = op;

	
	Collection<wartoscstandardowa2Only> dane = crudData.findByMaterialAndOperacja(material,operacja);
	return dane;
	
}




@RequestMapping(value = "/saveprod", method = RequestMethod.POST)
public String saveKod(@ModelAttribute("produkcja") produkcja produkcja, BindingResult BinResult) {
	if (BinResult.hasErrors()) {
		   List<FieldError> errors = BinResult.getFieldErrors();
		    for (FieldError error : errors ) {
		        System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
		    }
	return "error";
	}
	
    crud.save(produkcja);
    return "redirect:/";
	
}


@GetMapping("/edit")
public ModelAndView editrecord(@RequestParam long id) {
	ModelAndView mv = new ModelAndView("edit");
	produkcja produkcja = crud.getOne(id);
	mv.addObject("produkcja", produkcja);
	return mv;
	
}

@PostMapping("/editsave")
public String editrecord(@ModelAttribute("produkcja") produkcja produkcja) {
	crud.save(produkcja);
	return "redirect:/";
}


@GetMapping("/delete")
public String deleterecord(@RequestParam Long id) {
	crud.deleteById(id);
	return "redirect:/";
}
	
}
