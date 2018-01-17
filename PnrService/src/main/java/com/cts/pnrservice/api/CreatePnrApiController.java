package com.cts.pnrservice.api;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.pnrservice.model.AdvisoryMessage;
import com.cts.pnrservice.model.CreatePnrRequest;
import com.cts.pnrservice.model.CreatePnrResponse;
import com.cts.pnrservice.model.RecordLocatorInfo;
import com.cts.pnrservice.service.pnrCreationServiceImpl;
import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-16T07:29:02.569Z")

@Controller
public class CreatePnrApiController implements CreatePnrApi {



    public ResponseEntity<CreatePnrResponse> createPnr(@ApiParam(value = "" ,required=true )  @Valid @RequestBody CreatePnrRequest body) {
    	String pnrNumber = "";
    	CreatePnrResponse responce = new CreatePnrResponse();
    	AdvisoryMessage advMessage = new AdvisoryMessage();
    	RecordLocatorInfo recordlocater = new RecordLocatorInfo();
    	//System.out.println("Entered into createPnr");
    	try {
			pnrNumber = new pnrCreationServiceImpl().createPnr(body);
			//System.out.println("Created PNR --->"+pnrNumber);
			if(pnrNumber != null) {
				recordlocater.setPnrNo(pnrNumber);
				advMessage.setFreeformText("PNR Number generated Successfully!!!");
				
				responce.setAdvisoryMessage(advMessage);
				responce.setPassengerInfo(recordlocater);
			}else{
				recordlocater.setPnrNo(pnrNumber);
				advMessage.setFreeformText("Issue during PNR Creation");
				
				responce.setAdvisoryMessage(advMessage);
				responce.setPassengerInfo(recordlocater);
			}
		}catch(Exception ex) {
			System.out.println(ex);
			recordlocater.setPnrNo(pnrNumber);
			advMessage.setFreeformText("Issue during PNR Creation");
			
			responce.setAdvisoryMessage(advMessage);
			responce.setPassengerInfo(recordlocater);
		}
    	
    	 return new ResponseEntity<CreatePnrResponse>(responce, HttpStatus.OK);
    }

}
