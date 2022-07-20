package b3.k8s.selectDB.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.b3.k8s.sboot.select.gen.api.SelectLastApi;
import com.b3.k8s.sboot.select.gen.api.SelectLogApi;
import com.b3.k8s.sboot.select.gen.model.ApiModelListResponse;
import com.b3.k8s.sboot.select.gen.model.ApiModelResponse;

import b3.k8s.selectDB.service.SelectDbService;

@RestController
public class SelectLogController implements SelectLogApi {

	@Autowired
	SelectDbService service;

	@Override
	public ResponseEntity<ApiModelResponse> selectLog(Integer id) {

		ApiModelResponse response = service.getLog(id);
		return new ResponseEntity<ApiModelResponse>(response, HttpStatus.OK); 
		
		
	}
	

}
