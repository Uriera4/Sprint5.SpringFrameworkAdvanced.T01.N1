package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n01.S05T01N01RieraLizcanoOriol.Model.services;

import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n01.S05T01N01RieraLizcanoOriol.Model.domain.Sucursal;
import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n01.S05T01N01RieraLizcanoOriol.Model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n01.S05T01N01RieraLizcanoOriol.Model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    private Sucursal convertToSucursal (SucursalDTO sucursalDTO){
        Sucursal sucursal = new Sucursal(sucursalDTO.getNomSucursal(), sucursalDTO.getPaisSucursal());
        sucursal.setId(sucursalDTO.getPk_SucursalID());
        return sucursal;
    }
    private SucursalDTO convertToSucursalDTO (Sucursal sucursal){
        SucursalDTO sucursalDTO = null;
        if (sucursal!=null) sucursalDTO = createSurcursalDTO(sucursal);
        return sucursalDTO;
    }
    private SucursalDTO createSurcursalDTO (Sucursal sucursal){
        return new SucursalDTO(sucursal.getId(), sucursal.getNomSucursal(), sucursal.getPaisSucursal());
    }

    public SucursalDTO createSucursal (SucursalDTO sucursalDTO){
        Sucursal newSucursal;
        try{
            newSucursal = sucursalRepository.save(convertToSucursal(sucursalDTO));
        } catch (Exception e){
            newSucursal = null;
        }
        return convertToSucursalDTO(newSucursal);
    }
    public SucursalDTO updateSucursal (SucursalDTO sucursalDTO){
        Sucursal newSucursal = convertToSucursal(sucursalDTO);
        sucursalRepository.save(newSucursal);
        return convertToSucursalDTO(newSucursal);
    }
    public boolean deleteSucursal (Integer id){
        boolean deleted;
        try {
            sucursalRepository.deleteById(id);
            deleted = true;
        } catch (Exception e){
            deleted = false;
        }
        return deleted;
    }
    public SucursalDTO getOne (Integer id){
        return convertToSucursalDTO(sucursalRepository.findById(id).orElse(null));
    }
    public List<SucursalDTO> getAll (){
        List<Sucursal> sucursals = new ArrayList<>();
        try{
            sucursals.addAll(sucursalRepository.findAll());
        } catch (Exception e){
            sucursals.add(null);
        }
        return sucursals.stream().map(this::convertToSucursalDTO).toList();
    }

}
