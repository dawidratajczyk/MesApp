package MesAplication.resControler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class maszynyServis {
	
@Autowired
crudControlerDlaMaszyn crud;

	@GetMapping("/maszyny/all")
	@ResponseBody
	public List<maszyny> list(){
		return crud.findAll();
	}
	
	@GetMapping("/maszyny")
	public ModelAndView showmachine() {
	ModelAndView mv = new ModelAndView();
	List<maszyny> listamaszyn = crud.findAll();
	mv.addObject("maszyny", listamaszyn);
	mv.setViewName("maszyny");
	
	
	return mv;	
	}
	
	@GetMapping("/dodajmaszyne")
	public String newMachineAdd(Map<String,Object> model) {
		maszyny maszyna = new maszyny();
		model.put("modelmaszyny",maszyna);
		return "dodajMaszyne";
		
	}
	

	@RequestMapping(value = "/saveMachine", method = RequestMethod.POST)
	public String SaveMachine(@ModelAttribute("modelmaszyny") maszyny maszyny){
		crud.save(maszyny);
		return "redirect:/maszyny";
	}
	

}
