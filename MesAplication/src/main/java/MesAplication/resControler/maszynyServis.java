package MesAplication.resControler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import MesAplication.resControler.entities.maszyny;

@Controller
public class maszynyServis {
	
@Autowired
crudControlerDlaMaszyn crud;


	
	@GetMapping("/machines")
	public ModelAndView showmachine() {
	ModelAndView mv = new ModelAndView();
	List<maszyny> listamaszyn = crud.findAll();
	mv.addObject("maszyny", listamaszyn);
	mv.setViewName("machines");
	
	
	return mv;	
	}
	
	@GetMapping("/addMachine")
	public String newMachineAdd(Map<String,Object> model) {
		maszyny maszyna = new maszyny();
		model.put("modelmaszyny",maszyna);
		return "addMachine";
		
	}
	

	@RequestMapping(value = "/saveMachine", method = RequestMethod.POST)
	public String SaveMachine(@ModelAttribute("modelmaszyny") maszyny maszyny){
		crud.save(maszyny);
		return "redirect:/machines";
	}
	
	
	//* ponizszy kod odpowiedzialny za testy Ajaxa*//
	

	@ResponseBody
	@GetMapping("/obszary")
	public String pokazobszary() {
		Gson gson = new Gson();		
		return gson.toJson(crud.findAll());
	}
	
	@GetMapping("/maszyny/all")
	@ResponseBody
	public List<maszyny> list(){
		return crud.findAll();
	}
	

	
	@GetMapping("/deletemachine")
	public String deletemachine(@RequestParam Long id) {
		crud.deleteById(id);
		//return "redirect:/";
		return "redirect:/machines";	
	}
	
	
	
	//Endpoint nieużywany, słuzy do testów
		@GetMapping("/ajaxtest")
		public String testajax() {
			
			return "ajaxtest";
		}
		
	

}
