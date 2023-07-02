package com.web.controller;

import com.web.service.IAccesService;
import com.web.util.ConstantsUtil;
import com.web.util.PageRender;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.web.entity.EAcceso;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Acces", description = "Product management APIs")
@Controller
@RequestMapping("/views/")
public class AccesManageController {

    @Autowired
    private IAccesService service;
    ConstantsUtil constantsUtil = new ConstantsUtil();

    private static final Logger log = LoggerFactory.getLogger(AccesManageController.class);

    @Operation(
            summary = "Form to save a new acces",
            description = "Form to save a new acces, set title, kind and category.",
            tags = { "acces", "get" })
    @GetMapping("fnewacces")
    public String nuevoAceso(Model model){
        buildModel(null, "Formulario Nuevo Acceso", model);
        return constantsUtil.FORMULARIO_NUEVO_ACCESO;
    }

    @Operation(
            summary = "Endpoint to save a new acces",
            description = "Endpoint to save a new acces, set title, kind and category.",
            tags = { "acces", "post" })
    @PostMapping("/saveacces")
    public String Guardar(@Valid @ModelAttribute EAcceso nuevoacceso,
                          BindingResult result, Model model,
                          RedirectAttributes messagesAtributte){
        if(result.hasErrors()){

        }
        service.guardar(nuevoacceso);
        messagesAtributte.addFlashAttribute("succes", "ACCESO GUARDADO CON EXITO");
        return constantsUtil.REDIRECT_LISTADO_ACCESOS;
    }

    @Operation(
            summary = "Retrieve a list of all acces",
            description = "Get a list of all acces  object by specifying.",
            tags = { "acces", "get" })
    @RequestMapping("listAcces")
    public String getAcces(Model model){
       List<EAcceso> allAcces = service.getAllAcces();
       model.addAttribute("titulo", "Los Accesos");
       model.addAttribute("listadoaccesos", allAcces);
        return constantsUtil.VIEW_LISTADO_ACCESOS;
    }
    @GetMapping("listAccesos/{page}")
    public String listarAccesos(@RequestParam(name = "page", defaultValue = "0") int page,
                                Model model){
        Pageable pageRequest = PageRequest.of(page,2);
        Page<EAcceso> accesos = service.findAll(pageRequest);
        PageRender<EAcceso> pageRender = new PageRender<>("/listar",accesos);
        model.addAttribute("titulo","Listado de Accesos");
        model.addAttribute("listadoaccesos",accesos);
        model.addAttribute("page", pageRender);

       // return constantsUtil.REDIRECT_LISTADO_ACCESOS;
        return constantsUtil.VIEW_LISTADO_ACCESOS;
    }
    @GetMapping("/editacces/{id}")
    public String editAcces(@PathVariable("id")Long idAcces, Model model){
        if(idAcces>0) {
            buildModel(idAcces,"Formulario Editar Acces", model);
        }
        return constantsUtil.FORMULARIO_NUEVO_ACCESO;
    }
    @GetMapping("/deleteacces/{id}")
    public String deleteAcces(@PathVariable("id") Long idAcces, Model model){
        if(idAcces!=null){
            service.Eliminar(idAcces);
        }
        return constantsUtil.REDIRECT_LISTADO_ACCESOS;
    }


    private Model buildModel(Long id, String titulo,Model model){
        EAcceso nuevoacceso = new EAcceso();
        if(id!=null)
        {
            nuevoacceso = service.buscarPorID(id);
        }
        //List<CategoriasProductosEnum> lc= categoriaService.ListaCategoriasEnum();
        model.addAttribute("titulo", titulo);
        model.addAttribute("acceso", nuevoacceso);
        //model.addAttribute("categorias", lc);
        return model;
    }
}
