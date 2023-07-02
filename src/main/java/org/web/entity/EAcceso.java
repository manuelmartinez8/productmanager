package org.web.entity;

import com.web.model.Acceso;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="accesos")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EAcceso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min=5, max=50)
    @Column(name = "nombre",   length = 50)
    private String appNombre;
    @NotEmpty
    @Size(min=5, max=50)
    @Column(name = "usuario",   length = 50)
    private String appUsuario;
    @NotEmpty
    @Size(min=5, max=50)
    @Column(name = "password",   length = 50)
    private String appPassword;

    @Size(min=5, max=50)
    @Column(name = "secundarypassword",   length = 50)
    private String appPasswordSecundary;

    @Size(min=0, max=100)
    @Column(name = "preguntasecreta",   length = 100)
    private String appPreSecreta;

    public EAcceso(Acceso acceso) {
        this.id = acceso.getId();
        this.appNombre = acceso.getAppNombre();
        this.appUsuario = acceso.getAppUsuario();
        this.appPassword = acceso.getAppPassword();
        this.appPasswordSecundary = acceso.getAppPasswordSecundary();
        this.appPreSecreta = acceso.getAppPreSecreta();
    }
}
