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
import com.venta.proy.Cliente;
import com.venta.servicios.ServicioVenta;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	private String name="cliente";

	@Autowired
	ServicioVenta servicio;
	
	@RequestMapping("/index")
	public String lista(Model modelo) {
		//Envia a la vista es decir a la plantilla todas las Clientes
		modelo.addAttribute("clientes", servicio.findAllCli());
		//index.html en la carpeta cliente
		return name+"/index";
	}
	
	@RequestMapping("/new")
	public String nuevo(Model modelo) {
		modelo.addAttribute(new Cliente());
		modelo.addAttribute("url","save");
		modelo.addAttribute("editar","Nuevo");
		return name+"/new-edit";
	}
	
	// Ya tenemos el objeto  cliente lleno con los datos del formulario
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save( @Valid @ModelAttribute Cliente cliente, BindingResult validacion, Model modelo) {
		if (validacion.hasErrors()) {
			return "cliente/"+name+"/new";
		}else {
			servicio.saveCli(cliente);
			return "redirect:/"+name+"/index";
		}			
	}
	
	@RequestMapping("/edit")
	public String edit(@RequestParam("clave") Integer id, Model modelo) {
		modelo.addAttribute("cliente", servicio.findOneCli(id));
		modelo.addAttribute("url","update");
		modelo.addAttribute("editar","Editar");
		return name+"/new-edit";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@Valid @ModelAttribute Cliente cliente, BindingResult validacion, Model modelo) {
		if (validacion.hasErrors()) {
			return name+"/new-edit";
		} else {
			servicio.updateCli(cliente);
			return "redirect:/"+name+"/index";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("clave") Integer id, Model modelo) {
		servicio.deleteCli(new Cliente(id));
		return "redirect:/"+name+"/index";		
	}
}


