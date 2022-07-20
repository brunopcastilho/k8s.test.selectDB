package b3.k8s.selectDB.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.b3.k8s.sboot.select.gen.api.SelectLastApi;
import com.b3.k8s.sboot.select.gen.model.ApiModelListResponse;

import b3.k8s.selectDB.service.SelectDbService;

@RestController
public class SelectLastController implements SelectLastApi {

	@Autowired
	SelectDbService service;
	
	
	@Override
	public ResponseEntity<ApiModelListResponse> selectLast(Integer quantity) {
	
		ApiModelListResponse response = service.getLastLogs(quantity);
		return new ResponseEntity<ApiModelListResponse>(response , HttpStatus.OK);
		
		
	}

}
