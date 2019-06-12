package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Image;

import static kr.or.connect.reservation.dao.ImageSql.*;

@Repository
public class ImageDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Image> rowMapper = BeanPropertyRowMapper.newInstance(Image.class);

	public ImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	public List<Image> selectImageByType(String type) {
		Map<String, ? > params = Collections.singletonMap("type",type);
		return jdbc.query(SELECT_IMAGE_BY_TYPE, params, rowMapper);
	}
}
