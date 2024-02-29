package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n01.S05T01N01RieraLizcanoOriol.Model.dto;

import java.util.List;

public class SucursalDTO {

    private Integer pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;
    private String tipusSucursal = "Fora UE";
    private final List<String> countriesEU = List.of("Albania","Alemania","Andorra","Armenia","Austria","Azerbaiyán","Bélgica","Bielorrusia","Bosnia y Herzegovina","Bulgaria","Chipre","Croacia","Dinamarca","Eslovaquia","Eslovenia","España","Estonia","Finlandia","Francia","Georgia","Grecia","Hungría","Irlanda","Islandia","Italia","Letonia","Liechtenstein","Lituania","Luxemburgo","Macedonia del Norte","Malta","Moldavia","Mónaco","Montenegro","Noruega","Países Bajos","Polonia","Portugal","Reino Unido","República Checa","Rumania","Rusia","San Marino","Serbia","Suecia","Suiza","Turquía","Ucrania","Vaticano");

    public SucursalDTO(){}
    public SucursalDTO (Integer pk_SucursalID, String nomSucursal, String paisSucursal){
        this.pk_SucursalID = pk_SucursalID;
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
        this.tipusSucursal = returnTipusSucursal(tipusSucursal);
    }
    private String returnTipusSucursal(String tipusSucursal){
        if(countriesEU.stream().anyMatch(c -> c.equalsIgnoreCase(paisSucursal))){
            tipusSucursal = "UE";
        }
        return tipusSucursal;
    }

    public Integer getPk_SucursalID() {
        return pk_SucursalID;
    }
    public void setPk_SucursalID(Integer pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;}
    public String getNomSucursal() {
        return nomSucursal;
    }
    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }
    public String getPaisSucursal() {
        return paisSucursal;
    }
    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }
    public String getTipusSucursal() {
        return tipusSucursal;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "pk_SucursalID=" + pk_SucursalID +
                ", nomSucursal='" + nomSucursal + '\'' +
                ", paisSucursal='" + paisSucursal + '\'' +
                ", tipusSucursal='" + tipusSucursal + '\'' +
                '}';
    }
}
