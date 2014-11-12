/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.leona.station.services;


import br.leona.hardware.RetrieveServices.RetrieveService;
import br.leona.hardware.model.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 *
 * @author Admin_2
 */
public class ServerServices {
    private //final
            List<Service> listServices = new ArrayList<Service>();
    
    public ServerServices(){  
    }
    
    public void clearListServies(){        
       listServices.clear();         
    }
    
    public void setListServices(List<Service> listServices) {        
        this.listServices.addAll(listServices);        
    }

    public List<Service> getListServices() {        
        ServiceLoader<RetrieveService> servLoad = ServiceLoader.load(RetrieveService.class);       
        Iterator<RetrieveService> iterSL = servLoad.iterator();                   
        
        if(servLoad.iterator().hasNext()) {           
           while(iterSL.hasNext()) {
               RetrieveService rs = iterSL.next();               
               listServices.add(rs.getService());
            }            
        }
        else System.out.println("ServiceLoader Empty -  ServerServicos.listaServicos()");
        
        return listServices;     
    }
}
