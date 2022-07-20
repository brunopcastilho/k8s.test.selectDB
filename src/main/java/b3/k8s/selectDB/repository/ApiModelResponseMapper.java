package b3.k8s.selectDB.repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import org.springframework.jdbc.core.RowMapper;

import com.b3.k8s.sboot.select.gen.model.ApiModelResponse;

public class ApiModelResponseMapper implements RowMapper<ApiModelResponse>{

	@Override
	public ApiModelResponse mapRow(ResultSet arg0, int arg1) throws SQLException {
		ApiModelResponse response = new ApiModelResponse();
		response.setDtLog(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(arg0.getTimestamp("dtLog").toLocalDateTime()));
		response.setId(arg0.getInt("id"));
		response.setMessage(arg0.getString("message"));
		
		return response;
		
		
	}

	
	
}
