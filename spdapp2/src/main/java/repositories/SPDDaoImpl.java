package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.SPD;
import dao.SPDDAO;
import jdbc.DBUtil;

public class SPDDaoImpl implements SPDDAO {

	private static final String CONTEXT_LOOKUP = "java:/comp/env/jdbc/spd";
	private static final String SELECT_ALL_SPD = "select * from spd";
	private static final String SELECT_SPD_BY_ID = "select * from spd where id = ?";
	private static final String CREATE_SPD = "insert into spd (surname, firstname, lastname, alias, birthdate, inn, passport, employmentDate, terminationDateCheck, terminationDate) "
			+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_SPD = "update spd set surname=?, firstname=?, lastname=?, alias=?, birthdate=?, inn=?, passport=?, employmentDate=?, terminationDateCheck=?, terminationDate=? where id=?";
	private static final String DELETE_SPD = "delete from spd where id=?";

	private final DataSource dataSource;

	public SPDDaoImpl() {
		try {
			Context context = new InitialContext();
			try {
				dataSource = (DataSource) context.lookup(CONTEXT_LOOKUP);
			} finally {
				context.close();
			}
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void create(SPD spd) throws SQLException {
		Connection connection = dataSource.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(CREATE_SPD, Statement.RETURN_GENERATED_KEYS);
			statement.executeUpdate();
			try {
				ResultSet generatedKeys = statement.getGeneratedKeys();
				try {
					if (generatedKeys.next())
						spd.setId(generatedKeys.getInt("id"));
				} finally {
					generatedKeys.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	@Override
	public void update(SPD spd) throws SQLException {
		Connection connection = dataSource.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(UPDATE_SPD);
			try {
				statement.executeUpdate();
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	@Override
	public void delete(SPD spd) throws SQLException {
		Connection connection = dataSource.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(DELETE_SPD);
			try {
				statement.executeUpdate();
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	@Override
	public List<SPD> selectAll() throws SQLException {
		List<SPD> spdList = new ArrayList<SPD>();
		Connection connection = dataSource.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SPD);
			try {
				ResultSet results = statement.executeQuery();
				try {
					while (results.next()) {
						SPD spd = unmarshal(results);
						spdList.add(spd);
					}
				} finally {
					results.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return spdList;
	}

	@Override
	public SPD selectById(int id) throws SQLException {
		Connection connection = dataSource.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SELECT_SPD_BY_ID);
			try {
				ResultSet results = statement.executeQuery();
				try {
					if (results.next()) {
						return unmarshal(results);
					} else {
						return null;
					}
				} finally {
					results.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	private static SPD unmarshal(ResultSet results) throws SQLException {
		SPD spd = new SPD();
		spd.setId(results.getObject("id", Integer.class));
		spd.setSurname(results.getObject("surname", String.class));
		spd.setFirstname(results.getObject("firstname", String.class));
		spd.setLastname(results.getObject("lastname", String.class));
		spd.setAlias(results.getObject("alias", String.class));
		spd.setBirthdate(results.getObject("birthdate", Date.class));
		spd.setInn(results.getObject("inn", String.class));
		spd.setPassport(results.getObject("passport", String.class));
		spd.setEmploymentDate(results.getObject("employment_date", Date.class));
		spd.setTerminationDateCheck(results.getObject("termination_date_check", Boolean.class));
		spd.setTerminationDate(results.getObject("termination_date", Date.class));
		return spd;
	}

}
