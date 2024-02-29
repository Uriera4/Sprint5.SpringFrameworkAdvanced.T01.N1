package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n01.S05T01N01RieraLizcanoOriol.Model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "sucursals")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk_SucursalID;
    @Column (name = "nom")
    private String nomSucursal;
    @Column(name = "pais")
    private String paisSucursal;

    public Sucursal (){}
    public Sucursal (String nomSucursal, String paisSucursal){
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
    }

    public int getId() {
        return this.pk_SucursalID;
    }
    public void setId(Integer pk_SucursalID){
        this.pk_SucursalID = pk_SucursalID;
    }
    public String getNomSucursal() {
        return this.nomSucursal;
    }
    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }
    public String getPaisSucursal() {
        return this.paisSucursal;
    }
    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "pk_SucursalID=" + pk_SucursalID + ", nomSucursal='" + nomSucursal + '\'' + ", paisSucursal='" + paisSucursal + '\'' + '}';
    }

}
