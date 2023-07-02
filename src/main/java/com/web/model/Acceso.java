package com.web.model;

import lombok.*;
import org.web.entity.EAcceso;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Acceso {

    private Long id;
    @NotEmpty
    private String appNombre;
    @NotEmpty
    private String appUsuario;
    @NotEmpty
    private String appPassword;
    @NotEmpty
    private String appPasswordSecundary;
    @NotEmpty
    private String appPreSecreta;

    public Acceso(EAcceso acceso) {
        this.id = acceso.getId();
        this.appNombre = acceso.getAppNombre();
        this.appUsuario = acceso.getAppUsuario();
        this.appPassword = acceso.getAppPassword();
        this.appPasswordSecundary = acceso.getAppPasswordSecundary();
        this.appPreSecreta = acceso.getAppPreSecreta();
    }


}
