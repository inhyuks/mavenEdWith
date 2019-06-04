package kr.or.connect.springGuestBook.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.springGuestBook.dto.Log;

@Repository
public class LogDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	public LogDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("log")
				//id가 자동으로 입력된다
				.usingGeneratedKeyColumns("id");
	}
	
	public Long insert(Log log) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(log);
		//executeAndReturnKey insert문을 내부적으로 생성하여 실행하고 자동으로생성된 id 값을 리턴함
		return insertAction.executeAndReturnKey(params).longValue();
	}
}
