package org.example.DAO;

import org.example.bo.CustomerBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@Repository(value = "dao")
public class CustomerSQLDaoImpl implements ICustomerDao{
    static{
        System.out.println("CustomerSQLDaoImpl class is loading..");
    }
    public CustomerSQLDaoImpl()
    {
        System.out.println("CustomerSQLImpl :: object is created");
    }
    private static final String REALTIMEDI_CUSTOMER_INSERT_QUERY = "insert into customer(`cname`,`caddress`,`pamt`,`rate`,`time`,`intrAmt`)values(?,?,?,?,?,?)";
   @Autowired
    private DataSource dataSource;
    @Override
    public int save(CustomerBo bo) throws Exception {
        int count = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(REALTIMEDI_CUSTOMER_INSERT_QUERY)) {
            pstmt.setString(1, bo.getCustomerName());
            pstmt.setString(2, bo.getCustomerAddress());
            pstmt.setFloat(3, bo.getPamt());
            pstmt.setFloat(4, bo.getRate());
            pstmt.setFloat(5, bo.getTime());
            pstmt.setFloat(6, bo.getIntrAmount());

            count = pstmt.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
            throw se;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return count;
    }
}
