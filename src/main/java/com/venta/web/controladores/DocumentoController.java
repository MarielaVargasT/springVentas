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

import com.venta.proy.Documento;
import com.venta.servicios.ServicioVenta;

@Controller
@RequestMapping("/documento")
public class DocumentoController {
	private String name="documento";

	@Autowired
	ServicioVenta servicio;
	
	@RequestMapping("/index")
	public String lista(Model modelo) {
		//Envia a la vista es decir a la plantilla todas las Documentos
		modelo.addAttribute("documentos", servicio.findAllDoc());
		//index.html en la carpeta documento
		return name+"/index";
	}
	
	@RequestMapping("/new")
	public String nuevo(Model modelo) {
		modelo.addAttribute(new Documento());
		modelo.addAttribute("url","save");
		modelo.addAttribute("editar","Nuevo");
		return name+"/new-edit";
	}
	
	// Ya tenemos el objeto  documento lleno con los datos del formulario
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save( @Valid @ModelAttribute Documento documento, BindingResult validacion, Model modelo) {
		if (validacion.hasErrors()) {
			return "documento/"+name+"/new";
		}else {
			servicio.saveDoc(documento);
			return "redirect:/"+name+"/index";
		}			
	}
	
	@RequestMapping("/edit")
	public String edit(@RequestParam("clave") Integer id, Model modelo) {
		modelo.addAttribute("documento", servicio.findOneDoc(id));
		modelo.addAttribute("url","update");
		modelo.addAttribute("editar","Editar");
		return name+"/new-edit";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@Valid @ModelAttribute Documento documento, BindingResult validacion, Model modelo) {
		if (validacion.hasErrors()) {
			return name+"/new-edit";
		} else {
			servicio.updateDoc(documento);
			return "redirect:/"+name+"/index";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("clave") Integer id, Model modelo) {
		servicio.deleteDoc(new Documento(id));
		return "redirect:/"+name+"/index";
	}
}