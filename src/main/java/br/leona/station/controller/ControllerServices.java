/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.leona.station.controller;

import br.leona.hardware.services.Pantilt;
import br.leona.hardware.model.Service;
import br.leona.station.services.ServerServices;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Admin_2
 */
@WebService(serviceName = "ControllerServices")
public class ControllerServices {      
   private ServerServices serverServices;
   private Pantilt pantilt;
    
    public ControllerServices(){        
        serverServices = new ServerServices();
        pantilt = new Pantilt();
    }
    @WebMethod(operationName = "PegaListaServicos")
    public List<Service> getListServices() {     
        List<Service> listService = new ArrayList<Service>();
        listService.addAll(serverServices.getListServices());
        return  listService; 
    }  
    
    @WebMethod(operationName = "LimpaListaServicos")
    public void clearListServices() { 
        serverServices.clearListServies();
    }
      
    @WebMethod(operationName = "AlteraListaServicos")
    public void setListeServices(@WebParam(name = "listaServicos") List<Service> listaServices) { 
        serverServices.setListServices(listaServices);
    }
    
    @WebMethod(operationName = "VerificaPantiltLigado")
    public int isOnPantilt() throws IOException {
        return pantilt.isOn();
    }
   
    @WebMethod(operationName = "LigaPantilit")
    public int turnOnPantilt() {
        return pantilt.turnOn();
    }    
   
    @WebMethod(operationName = "ReiniciaPantilt")
    public int resetPantilt() {
        return pantilt.reset();
    }
  
    @WebMethod(operationName = "DesligaPantilit")
    public int turnOffPantilt() {
        return  pantilt.turnOff();
    }
        
    @WebMethod(operationName = "DesligaArduino")
    public int close() {
        return  pantilt.close();
    }
   
    @WebMethod(operationName = "MoveDirecaoPantilt")
    public int moveDirection(@WebParam(name = "graus") String graus, 
                             @WebParam(name = "direcao") String direcao) {
        return pantilt.moveDirection(graus, direcao);
    }   
   
}


