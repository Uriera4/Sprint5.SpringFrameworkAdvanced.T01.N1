package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n01.S05T01N01RieraLizcanoOriol.Controllers;

import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n01.S05T01N01RieraLizcanoOriol.Model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n01.S05T01N01RieraLizcanoOriol.Model.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("/add")
    public String showRegisterFormulary (Model model){
        model.addAttribute("sucursal", new SucursalDTO());
        return "createSucursal";
    }
    @PostMapping("/add")
    public String createSucursal (@ModelAttribute("sucursal") SucursalDTO sucursalDTO){
        SucursalDTO newSucursal = sucursalService.createSucursal(sucursalDTO);
        String result = "internalServerError";
        if (newSucursal!=null){
            result = "redirect:/sucursal/getAll";
        }
        return result;
    }

    @GetMapping("/update/{id}")
    public String showUpdateFormulary (@PathVariable("id") Integer id, Model model){
        String result = "notFound";
        SucursalDTO newSucursal = sucursalService.getOne(id);
        if (newSucursal!=null){
            model.addAttribute("sucursal", newSucursal);
            result = "updateSucursal";
        }
        return result;
    }
    @PostMapping("/update/{id}")
    public String updateSucursal (@PathVariable("id") Integer id, @ModelAttribute("sucursal") SucursalDTO sucursalDTO){
        String result = "internalServerError";
        sucursalDTO.setPk_SucursalID(id);
        if (sucursalService.updateSucursal(sucursalDTO)!=null){
            result = "redirect:/sucursal/getAll";
        }
        return result;
    }

    @GetMapping("/delete/{id}")
    public String deleteSucursal (@PathVariable("id") Integer id){
        String result = "internalServerError";
        if(sucursalService.deleteSucursal(id)){
            result = "redirect:/sucursal/getAll";
        }
        return result;
    }

    @GetMapping("/getOne")
    public String getSucursal (@RequestParam(value = "id") Integer id, Model model){
        String result = "notFound";
        SucursalDTO newSucursal = sucursalService.getOne(id);
        if (newSucursal!=null){
            model.addAttribute("id", id);
            newSucursal.setPk_SucursalID(id);
            model.addAttribute("sucursal", newSucursal);
            result = "showSucursal";
        }
        return result;
    }
    @GetMapping({"","/","/getAll"})
    public String getSucursals (Model model){
        String result = "internalServerError";
        List<SucursalDTO> sucursals = sucursalService.getAll();
        if (sucursals.isEmpty()){
            result = "noContent";
        } else {
            if (sucursals.getFirst()!=null){
                model.addAttribute("sucursals", sucursals);
                result = "showSucursals";
            }
        }
        return result;
    }

    @GetMapping("/error")
    public String getError(){
        return "error";
    }

}
