package com.fdr.qrcss.DataBase;
import com.fdr.qrcss.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by FERGANI DIA EL EDDINE on 05/10/2020 at 14.
 * FdR for development
 * Dia.fergani@univ-constantine2.dz
 */

@Repository
public class ProductData {


    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insert(Product product) {

        return jdbcTemplate.update("insert into product (num,name,mark )"+" values (?,?,?)",

                new Object[]{product.getNum(), product.getName(), product.getMark()}
        );
    }



    public int delete(int id) {
        return jdbcTemplate.update("delete from  product where id=? ", new Object[]{id});

    }

    static class UserRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet resultSet, int i) throws SQLException {
            Product product = new Product(
                    resultSet.getInt("id"),
                    resultSet.getInt("num"),
                    resultSet.getInt("quantity"),
                    resultSet.getInt("price"),
                    resultSet.getString("name"),
                    resultSet.getString("mark")
            );
            return product;
        }
    }

    public List<Product> GetAllProduct() {
        return jdbcTemplate.query
                ("select* from product", new UserRowMapper());
    }

    public int UpdataProduct (Product product )
    {
        return jdbcTemplate.update("update product set quantity = ? where id =?",
                new Object []{product.getId(),product.getQuantity()});
    }
}




