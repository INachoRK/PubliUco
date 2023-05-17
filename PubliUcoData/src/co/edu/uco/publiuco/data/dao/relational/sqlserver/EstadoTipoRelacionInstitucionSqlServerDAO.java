package co.edu.uco.publiuco.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import co.edu.uco.publiuco.crosscutting.exception.PubliUcoDataException;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.data.dao.EstadoTipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.relational.SqlDAO;
import co.edu.uco.publiuco.entities.EstadoTipoRelacionInstitucionEntity;

public final class EstadoTipoRelacionInstitucionSqlServerDAO extends SqlDAO<EstadoTipoRelacionInstitucionEntity>
		implements EstadoTipoRelacionInstitucionDAO {

	public EstadoTipoRelacionInstitucionSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(final EstadoTipoRelacionInstitucionEntity entity) {
		
		var sqlStatement = "UPDATE EstadotipoRelacionInstitucion SET nombre=?, descripcion= ? WHERE identificador=?";
		
			try (var prepareStatement = getConnection().prepareStatement(sqlStatement)) {
			
			prepareStatement.setString(1, entity.getNombre());
			prepareStatement.setString(2, entity.getDescripcion());
			prepareStatement.setObject(3, entity.getIdentificador());
			
			prepareStatement.executeUpdate();
			
		
		var sqlStatement = "INSERT INTO EstadoTipoRelacionInstitucion(codigo, nombre, descripcion)";
		
		try (var prepareStatement = getConnection().prepareStatement(sqlStatement)) {
			
			prepareStatement.setObject(1, entity.getIdentificador());
			prepareStatement.setString(2, entity.getNombre());
			prepareStatement.setString(3, entity.getDescripcion());
			
			prepareStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = "Se ha registrado un problema al crear un nuevo tipo relacion institución...";
			var technicalMessage = "Se ha presentado un error de tipo SQLException dentro del método EstadoTipoRelacionInstitucionSQLDAO";
			
			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);
			
		} catch (final Exception exception) {
			var userMessage = "Se ha registrado un problema inesperado al crear un nuevo tipo relacion institución...";
			var technicalMessage = "Se ha presentado un problema inesperado del método EstadoTipoRelacionInstitucionSQLDAO";
		}
		

	}

	@Override
	public final List<EstadoTipoRelacionInstitucionEntity> read(final EstadoTipoRelacionInstitucionEntity entity) {
		var sqlStatement = new StringBuilder();
		var parameters = new ArrayList<>();
		
		sqlStatement.append(prepareSelect());
		sqlStatement.append(prepareFrom());
		sqlStatement.append(prepareWhere(entity, parameters));
		sqlStatement.append(prepareOrderBy());
		
		try (var preparedStatement = getConnection().preparedStatement(sqlStatement.toString())) {
			
		}catch (SQLException exception) {
			//TODO: handle exception
		}catch (Exception exception) {
			//TODO: handle exception
		}
		
		return null;
	}

	@Override
	protected final String prepareSelect() {
		return "SELECT identificador, nombre, descripcion";
	}

	@Override
	protected final String prepareFrom() {
		return "FROM EstadotipoRelacionInsttitucion";
	}

	@Override
	protected final String prepareWhere(EstadoTipoRelacionInstitucionEntity entity, List<Object> parameters) {
		
		final var where = new StringBuilder("");
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());
		
		var steWhere = true;
		
		if (!UtilObject.isNull(entity)) {
			
			if(UtilUUID.isDefault(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE identificador=?");
				setWhere = false;
			}
			
			if(UtilText.getUtilText().isEmpty(entity.getNombre())) {
				parameters.add(entity.getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("nombre=? ");
				setWhere = false;
			}
			
			if(UtilText.getUtilText().isEmpty(entity.getDescripcion())) {
				parameters.add(entity.getDescripcion());
				where.append("WHERE descripcion LIKE %?%");
			}
			
		}
		
		return where.toString();
	}

	@Override
	protected final String prepareOrderBy() {
		return "ORDER BY nombre ASC";
	}
	
}
