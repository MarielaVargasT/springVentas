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
import com.venta.proy.Producto;
import com.venta.servicios.ServicioVenta;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	private String name="producto";

	@Autowired
	ServicioVenta servicio;
	
	@RequestMapping("/index")
	public String lista(Model modelo) {
		//Envia a la vista es decir a la plantilla todas las Productos
		modelo.addAttribute("productos", servicio.findAllProd());
		//index.html en la carpeta producto
		return name+"/index";
	}
	
	@RequestMapping("/new")
	public String nuevo(Model modelo) {
		modelo.addAttribute(new Producto());
		modelo.addAttribute("categorias",servicio.findAllCat());
		modelo.addAttribute("url","save");
		modelo.addAttribute("editar","Nuevo");
		return name+"/new-edit";
	}
	
	// Ya tenemos el objeto  producto lleno con los datos del formulario
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save( @Valid @ModelAttribute Producto producto, BindingResult validacion, Model modelo) {
		if (validacion.hasErrors()) {
			return "producto/"+name+"/new";
		}else {
			servicio.saveProd(producto);
			return "redirect:/"+name+"/index";
		}			
	}
	
	@RequestMapping("/edit")
	public String edit(@RequestParam("clave") Integer id, Model modelo) {
		modelo.addAttribute("producto", servicio.findOneProd(id));
		modelo.addAttribute("categorias",servicio.findAllCat());
		modelo.addAttribute("url","update");
		modelo.addAttribute("editar","Editar");
		return name+"/new-edit";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@Valid @ModelAttribute Producto producto, BindingResult validacion, Model modelo) {
		if (validacion.hasErrors()) {
			return name+"/new-edit";
		} else {
			servicio.updateProd(producto);
			return "redirect:/"+name+"/index";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("clave") Integer id, Model modelo) {
		servicio.deleteProd(new Producto(id));
		return "redirect:/"+name+"/index";		
	}
}
