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

import com.venta.proy.Categoria;
import com.venta.servicios.ServicioVenta;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	private String name="categoria";

	@Autowired
	ServicioVenta servicio;

	@RequestMapping("/index")
	public String lista(Model modelo) {
		//Envia a la vista es decir a la plantilla todas las Categorias
		modelo.addAttribute("categorias", servicio.findAllCat());
		//cat-index.html en la carpeta categoria
		return name+"/cat-index";
	}
	
	@RequestMapping("/new")
	public String fNuevaCategoria(Model modelo) {
		modelo.addAttribute(new Categoria());
		modelo.addAttribute("url","save");
		modelo.addAttribute("editar","Nueva");
		return name+"/cat-new-edit";
	}
	
	// Ya tenemos el objeto  categoria lleno con los datos del formulario
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveCategoria( @Valid @ModelAttribute Categoria categoria, BindingResult validacion, Model modelo) {
		if (validacion.hasErrors()) {
			return "redirect:/"+name+"/new";
		}else {
			servicio.saveCat(categoria);
			return "redirect:/"+name+"/index";
		}
	}
	
	@RequestMapping("/edit")
	public String editCategoria(@RequestParam("clave") Integer id, Model modelo) {
		modelo.addAttribute("categoria", servicio.findOneCat(id));
		modelo.addAttribute("url","update");
		modelo.addAttribute("editar","Editar");
		return name+"/cat-new-edit";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateCat(@Valid @ModelAttribute Categoria categoria, BindingResult validacion, Model modelo) {		
		if (validacion.hasErrors()) {
			return name+"/cat-edit";
		} else {
			servicio.updateCat(categoria);
			return "redirect:/"+name+"/index";
		}
	}
	
	@RequestMapping("/delete")
	public String borrarCategoria(@RequestParam("clave") Integer id, Model modelo) {
		servicio.deleteCat(new Categoria(id));
		return "redirect:/"+name+"/index";		
	}
}


