package tn.esprit.internshipmodule.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.internshipmodule.entities.Enterprise;
import tn.esprit.internshipmodule.service.EnterpriseService;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/Enterprise")
public class EnterpriseRestController {
        private final EnterpriseService enterpriseService;
        @PostMapping("/add")
        Enterprise addEnterprise(@RequestBody Enterprise enterprise){
            return enterpriseService.createOrUpdateEnterprise(enterprise);
        }

        @PutMapping("/update/{idE}")
        Enterprise updateEnterprise(@RequestBody Enterprise enterprise){
            return enterpriseService. createOrUpdateEnterprise(enterprise);
        }
        @GetMapping("/get/{idE}")
        Enterprise getEnterprise(@PathVariable("idE") Long idEnterprise){
            return enterpriseService.retrieveAnEnterprise(idEnterprise);
        }
        @GetMapping("/all")
        List<Enterprise> getAllEnterprise(){
            return enterpriseService.retrieveAllEnterprise();
        }
        @DeleteMapping("/delete/{idE}")
        void deleteEnterprise(@PathVariable("idE") Long idEnterprise) {
            enterpriseService.removeEnterprise(idEnterprise);
        }
}
