package com.example.khademni.controllers;

import com.example.khademni.entity.Response;
import com.example.khademni.services.ResponseServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/response")
@AllArgsConstructor
@RestController
public class ResponseRestController {

    ResponseServices responseService;


    @GetMapping("/listResponses")
    @ResponseBody
    public List<Response> listResponses(){
        return responseService.getAll();
    }


    @PostMapping("/add-response/{idRec}")
    @ResponseBody
    public void addResponse(@RequestBody Response r, @PathVariable("idRec") Long idRec)
    {
        responseService.addResponse(r,idRec);

    }


    @DeleteMapping("/deleteResponse/{idResponse}")
    @ResponseBody
    public void deleteResponse(@PathVariable("idResponse") Long idResponse){
        responseService.deleteResponse(idResponse);
    }


    @PutMapping("/modifierResponse/{idResponse}")
    @ResponseBody
    public void modifierResponse(@RequestBody Response r,@PathVariable("idResponse") Long idResponse){
        responseService.updateResponse(r,idResponse);
    }

    @PutMapping("/getResponsesByReclamation/{idRec}")
    @ResponseBody
    public List<Response> getResponsesByReclamation(@PathVariable("idRec") Long idRec){
        return responseService.getResponsesByReclamation(idRec);
    }
}
