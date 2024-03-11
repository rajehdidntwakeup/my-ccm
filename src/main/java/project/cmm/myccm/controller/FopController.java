package project.cmm.myccm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.cmm.myccm.core.model.request.FopRequest;
import project.cmm.myccm.core.model.response.FopResponse;
import project.cmm.myccm.service.FopService;

@RestController
@RequestMapping(path = "/contract")
public class FopController {

	@Autowired
	private FopService fopService;
	
	public ResponseEntity<FopResponse> createDocument(@RequestBody FopRequest request) {
		FopResponse response = fopService.startFopProcess(request);
		
		if (response != null) {
			return new ResponseEntity<FopResponse>(response, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
