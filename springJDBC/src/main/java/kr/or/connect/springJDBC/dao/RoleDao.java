package kr.or.connect.springJDBC.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.springJDBC.dto.Role;
import static kr.or.connect.springJDBC.dao.RoleDaoSqls.*; // roledao에있는 쿼리문을 가져오기위함 static 은 클래스이름사용할필요가없기위함

import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Repository // 저장소의 역할을 한다.
public class RoleDao {
	private NamedParameterJdbcTemplate jdbc; //?매핑했을떄 알아보기힘들어서 사용
	private SimpleJdbcInsert insertAction;
	//insert 하기위한 jdbc 객체
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);
	//BeanPropertyRowMapper에는 db와 java의 문법을 맞춰주는기능이있음,컬럼값을 자동으로 저장시켜주는 기능
	public RoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("role");
	}
	
	public List<Role> selectAll(){
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
		//쿼리문 ,비어있는 맵객체 , 객체전달 / sql문에 바인딩할 결과값이있으면 바인딩값을 전달할목적으로 map객체를 사용
		//세번째 파라미터는 select 문의 한건한건을 dto에 저장할목적으로 사용
	}
	
	public int insert(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		//role객체에 있는값을 map으로 변환하함
		return insertAction.execute(params);
		//이런 맵객체를 execute 메서드의 파라미터로 전달할경우 값이 알아서 저장됨
	}
	
	public int update(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return jdbc.update(UPDATE,params);
		//첫번째 파람은 SQL, 두번째는 맵객체(값을채워줄 객체)
	}
}
