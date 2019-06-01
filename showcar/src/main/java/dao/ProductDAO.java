package dao;

import bean.ProductBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public List<ProductBean> ListProduct() {
        List<ProductBean> list = new ArrayList<ProductBean>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8", "root", "root");
            String sql = "select * from product order by id desc";

            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet set = ps.executeQuery();

            while (set.next()){
                ProductBean productBean=new ProductBean();
                productBean.setId(set.getInt("id"));
                productBean.setName(set.getString("name"));
                productBean.setPrice(set.getFloat("price"));
                list.add(productBean);
            }

            ps.close();
            set.close();
        } catch (Exception ex) {

        }
        return list;
    }

}
