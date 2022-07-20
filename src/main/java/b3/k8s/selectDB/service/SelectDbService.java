package b3.k8s.selectDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b3.k8s.sboot.select.gen.model.ApiModelListResponse;
import com.b3.k8s.sboot.select.gen.model.ApiModelResponse;

import b3.k8s.selectDB.repository.SelectDbRepository;

@Service
public class SelectDbService {

	@Autowired
	SelectDbRepository repository;
	
	
	public ApiModelListResponse getLastLogs(int quantity){
	
		ApiModelListResponse list = new ApiModelListResponse();
		
		List<ApiModelResponse> lst = repository.getLastLogs(quantity);
		list.setElements(lst);
		list.setCode(0);
		
		return list;
		
		
		
	}
	
	public ApiModelResponse getLog(int id) {
		
		return repository.getLog(id);
		
	}
	
	
}
