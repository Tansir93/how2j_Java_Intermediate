package servlet;

import bean.ProductBean;
import dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDAO productDAO=new ProductDAO();
        List<ProductBean> productBeanList=productDAO.ListProduct();
        req.setAttribute("productBeanList",productBeanList);
        //服务端跳转
        req.getRequestDispatcher("listProduct.jsp").forward(req,resp);
    }
}
