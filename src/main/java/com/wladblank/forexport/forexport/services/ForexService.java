package com.wladblank.forexport.forexport.services;

import org.springframework.stereotype.Service;

@Service
public class ForexService {
    
    String url = "https://www.investing.com/instruments/Service/GetTechincalData";
    //gives 1 minute, 5 minutes, 15 minutes, 30 minutes, 1 hour, 5 hours and 1 day array.
    String xrequest= "X-Requested-With:XMLHttpRequest";
       
    




}
