package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
public abstract class DAO<T>
{
    public abstract int insert(T entity);
    public abstract T findById(int id);
    public abstract int deleteById(int id);
    public abstract ArrayList<T> getAllRecords();
    public abstract int update(T entity);

    protected final Connection connection;
    //maybe make it singleton
    public DAO(Connection connection) {
        this.connection = connection;
    }
    //updating the database
    protected int executeUpdate(String sql) throws SQLException
     {
        try (PreparedStatement statement =
                 connection.prepareStatement(sql)) {

           
            return statement.executeUpdate();
        }
    }
    


}