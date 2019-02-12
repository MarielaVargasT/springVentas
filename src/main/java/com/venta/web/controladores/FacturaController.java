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

import com.venta.proy.Factura;
import com.venta.servicios.ServicioVenta;

@Controller
@RequestMapping("/factura")
public class FacturaController {
	private String name="factura";

    @Autowired
    ServicioVenta servicio;
    
    @RequestMapping("/index")
    public String lista(Model modelo) {
        //Envia a la vista es decir a la plantilla todas las Facturas
        modelo.addAttribute("facturas", servicio.findAllFac());
        //index.html en la carpeta factura
        return name+"/index";
    }
    
    @RequestMapping("/new")
    public String nuevo(Model modelo) {
        modelo.addAttribute(new Factura());
        modelo.addAttribute("clientes", servicio.findAllCli());
        modelo.addAttribute("documentos",servicio.findAllDoc());
        modelo.addAttribute("productos", servicio.findAllProd());
        modelo.addAttribute("url","save");
        modelo.addAttribute("editar","Nueva");
        return name+"/new-edit";
    }
    
    // Ya tenemos el objeto  factura lleno con los datos del formulario
    @RequestMapping(value="/save",method=RequestMethod.POST)
    public String save( @Valid @ModelAttribute Factura factura, BindingResult validacion, Model modelo) {
        if (validacion.hasErrors()) {
            return "factura/"+name+"/new";
        }else {
            servicio.saveFac(factura);
            return "redirect:/"+name+"/index";
        }
    }
    
    @RequestMapping("/edit")
    public String edit(@RequestParam("clave") Integer id, Model modelo) {
        modelo.addAttribute("factura", servicio.findOneFac(id));
        modelo.addAttribute("url","update");
        modelo.addAttribute("editar","Editar");
        return name+"/new-edit";
    }
    
    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update(@Valid @ModelAttribute Factura factura, BindingResult validacion, Model modelo) {
        if (validacion.hasErrors()) {
            return name+"/new-edit";
        } else {
            servicio.updateFac(factura);
            return "redirect:/"+name+"/index";
        }
    }
    
    @RequestMapping("/delete")
    public String delete(@RequestParam("clave") Integer id, Model modelo) {
        servicio.deleteFac(new Factura(id));
        return "redirect:/"+name+"/index";
    }
}