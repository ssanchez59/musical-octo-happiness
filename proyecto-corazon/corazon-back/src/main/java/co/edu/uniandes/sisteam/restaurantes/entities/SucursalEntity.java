/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.sisteam.restaurantes.entities;

import java.io.Serializable;
import javax.persistence.Entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;


@Entity
public class SucursalEntity extends BaseEntity implements Serializable {

    @PodamExclude
    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MesaEntity> mesas = new ArrayList<>();
    
    @PodamExclude
    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlatoEspEntity> platosEsp = new ArrayList<>();
     
    @PodamExclude
    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DomicilioEntity> domicilios = new ArrayList<>();
    
//    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ReservaEntity> reservas = new ArrayList<>();

   
     
    private String ubicacion;
    private String direccion;

    /**
     * Obtiene la colección de mesa.
     * @return colección mesa. 
     */
    public List<MesaEntity> getMesas() {
        return mesas;
    }

    /**
     * Establece el valor de la colección de mesa.
     * @param mesas nuevo valor de la colección. 
     */
    public void setMesas(List<MesaEntity> mesas) {
        this.mesas = mesas;
    }
    
    /**
     * Establece el valor de la colección de mesa.
     * @param mesas nuevo valor de la colección. 
     */
    public void add(MesaEntity mesa) {
        this.mesas.add(mesa);
    }
    
     /**
     * Obtiene la colección de platoEsp.
     * @return colección platoEsp. 
     */
    public List<PlatoEspEntity> getPlatosEsp() {
        return platosEsp;
    }

    /**
     * Establece el valor de la colección de platoEsp.
     * @param platosEsp nuevo valor de la colección. 
     */
    public void setPlatosEsp(List<PlatoEspEntity> platosEsp) {
        this.platosEsp = platosEsp;
    }
    
    /**
     * Obtiene la colección de domicilios.
     * @return colección domicilios. 
     */
    public List<DomicilioEntity> getDomicilios() {
        return domicilios;
    }

    /**
     * Establece el valor de la colección de domicilios.
     * @param domicilios nuevo valor de la colección. 
     */
    public void setDomicilios(List<DomicilioEntity> domicilios) {
        this.domicilios = domicilios;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    

}
