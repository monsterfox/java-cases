package com.foxbill.servlet;

import com.foxbill.domain.Student;
import com.foxbill.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/regservlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //接收请求参数
        String strName = request.getParameter("name");
        String strAge = request.getParameter("age");

        //获取Spring容器，获取service对象
        /**
         * 第一种方式： 直接从 ServletContext 中获取
         */

//        String attr = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
//        WebApplicationContext ctx = (WebApplicationContext) this.getServletContext().getAttribute(attr);

        /**
         * 第二种方式：通过 WebApplicationContextUtils 获取
         */

        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());

        System.out.println("容器的信息：" + ctx);
        StudentService service = (StudentService) ctx.getBean("studentService");

        Student student = new Student();
        student.setName(strName);
        student.setAge(Integer.parseInt(strAge));
        //调用service方法
        service.addStudent(student);

        //显示处理结果的jsp
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }
}
