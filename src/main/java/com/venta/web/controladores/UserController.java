package com.venta.web.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.venta.proy.User;
import com.venta.servicios.ServicioVenta;

@Controller
@RequestMapping("/user")
public class UserController {
	private String name="user";

	@Autowired
	ServicioVenta servicio;
	
	@RequestMapping("/index")
	public String lista(Model modelo) {
		//Envia a la vista es decir a la plantilla todas las Users
		modelo.addAttribute("users", servicio.findAllUser());
		//index.html en la carpeta user
		return name+"/index";
	}
	
	@RequestMapping("/new")
	public String nuevo(Model modelo) {
		modelo.addAttribute(new User());
		modelo.addAttribute("url","save");
		modelo.addAttribute("editar","Nuevo");
		return name+"/new-edit";
	}
	
	// Ya tenemos el objeto  user lleno con los datos del formulario
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save( @Valid @ModelAttribute User user, BindingResult validacion, Model modelo) {
		if (validacion.hasErrors()) {
			return "user/"+name+"/new";
		}else {
			servicio.saveUser(user);
			return "redirect:/"+name+"/index";
		}			
	}
	
	@RequestMapping("/edit")
	public String edit(@RequestParam("clave") Integer id, Model modelo) {
		modelo.addAttribute("user", servicio.findOneUser(id));
		modelo.addAttribute("url","update");
		modelo.addAttribute("editar","Editar");
		return name+"/new-edit";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@Valid @ModelAttribute User user, BindingResult validacion, Model modelo) {
		if (validacion.hasErrors()) {
			return name+"/new-edit";
		} else {
			servicio.updateUser(user);
			return "redirect:/"+name+"/index";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("clave") Integer id, Model modelo) {
		servicio.deleteUser(new User(id));
		return "redirect:/"+name+"/index";		
	}
}


