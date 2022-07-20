package b3.k8s.selectDB.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.b3.k8s.sboot.select.gen.model.ApiModelListResponse;
import com.b3.k8s.sboot.select.gen.model.ApiModelResponse;

@Repository
public class SelectDbRepository {

	NamedParameterJdbcTemplate jdbc;	
	
	@Autowired
	public SelectDbRepository(NamedParameterJdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	public ApiModelResponse insertLog(String message) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("value", message);
		
		
		jdbc.update("INSERT INTO k8s.teste (dtLog , message) values (current_date() , :value) ;", namedParameters, keyHolder);
		
		namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("id", keyHolder.getKey());

		return jdbc.query("select * from k8s.teste where id = :id", namedParameters, new ApiModelResponseMapper()).get(0);


		
		
		
	}

	public List<ApiModelResponse> getLastLogs(int quantity) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("quantity", quantity);

		return jdbc.query("SELECT * FROM k8s.teste LIMIT :quantity ;", namedParameters, new ApiModelResponseMapper());
		
	}

	public ApiModelResponse getLog(int id) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("id", id);
		
		return jdbc.query("SELECT * FROM k8s.teste WHERE id = :id ;", namedParameters, new ApiModelResponseMapper()).get(0);		
		
	}

	
	
}
