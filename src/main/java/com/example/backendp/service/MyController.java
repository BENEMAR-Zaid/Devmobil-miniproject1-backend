/* Group du travaille : 
 * 
 * BENAMAR Zaid   (MBD)
 * AARAB Yasmine  (MBD)
 * 
 * */

package com.example.backendp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

@RestController
@RequestMapping(produces = "application/json")
public class MyController {
	@Autowired
	ConvertionDao convdao;
	
    @RequestMapping("/")
	public String helloPage()  {
    	
    	return " Hello World ";
	}
   
    
    @GetMapping("/specify/{from}/{to}/{value}")
    public ResponseEntity<Map<String, Float>> get2(@PathVariable("from") String from, @PathVariable("to") String to , @PathVariable("value") Float value) throws IOException {
    	String myUrl = "https://api.exchangerate.host/convert?from=" + from + "&to=" + to;
    	URL sURL = new URL(myUrl);
	    ObjectMapper mapper = new ObjectMapper();
	    String taux =  mapper.readTree(sURL).get("info").get("rate").asText();
	    // Parsing String to Float
	    Float result = Float.parseFloat(taux) * value;
	    this.saveConvertions(from,to,value,result);
	    
	    return ResponseEntity.status(HttpStatus.OK).body(Map.of(
	            "resultat", result));
	}
    
    
    
    public void saveConvertions(String from,String to,Float value, Float result) {
    	
    	ConvertionEntity conv = new ConvertionEntity();
    	conv.setFrom(from);
    	conv.setTo(to);
    	conv.setValue(value);
    	conv.setResult(result);
    	
    	this.convdao.save(conv);
    	
    }
}
