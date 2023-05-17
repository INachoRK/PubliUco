package co.edu.uco.publiuco.data.dao.relational;

import java.sql.Connection;
	
public abstract class SqlDAO<E> {
		
	private Connection connection;
	
	protected SqlDAO(final Connection connection)
	
	protected final Connection getConnection() {
		return connection;
	}
	
	protected final Connection
	
	protected abstract String prepareSelect();
	
	protected abstract String prepareFrom();
	
	protected abstract String prepareWhere(E entity, List<Object> parameters);
	
	protected abstract String prepareOrderBy();
	
}
