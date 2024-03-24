package com.foxbill.controller;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foxbill.dao.*;
import com.foxbill.pojo.*;
import com.foxbill.util.MyBatisUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/service")
public class ServiceServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 *
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.修改编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		//2.获取参数
		String action = request.getParameter("action");

		FoodMapper foodDao = MyBatisUtil.getSqlSession().getMapper(FoodMapper.class);
		System.out.println(action);
		if(action.equals("addFood")){ //添加菜品
			// 为解析类提供配置信息
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 创建解析类的实例
			ServletFileUpload sfu = new ServletFileUpload(factory);
			// 开始解析
			sfu.setFileSizeMax(1024 * 1024 * 10);
			// 每个表单域中数据会封装到一个对应的FileItem对象上
			try {
				List<FileItem> items = sfu.parseRequest(request);
				// 区分表单域
				String fileName = "";
				String foodName = "";
				int cid = 0;
				float fprice = 0;
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
					// isFormField为true，表示这不是文件上传表单域
					if (!item.isFormField()) {
						ServletContext sctx = getServletContext();
						// 获得存放文件的物理路径
						// upload下的某个文件夹 得到当前在线的用户 找到对应的文件夹

						String path = sctx.getRealPath("/foodImg");
						System.out.println(path);
						// 获得文件名
						fileName = item.getName();
						System.out.println(fileName);
						// 该方法在某些平台(操作系统),会返回路径+文件名
						fileName = fileName
								.substring(fileName.lastIndexOf("/") + 1);
						File file = new File(path + "\\" + fileName);
						if (!file.exists()) {
							item.write(file);
							// 将上传图片的名字记录到数据库中
						}
					}else{
						if("fname".equals(item.getFieldName())){
							foodName = item.getString("utf-8").trim();
						}

						if("fprice".equals(item.getFieldName())){
							fprice = Float.parseFloat(item.getString("utf-8").trim());
						}
					}
				}

				//构建Food实体类
				Food f = new Food(foodName,fprice,fileName);
				//添加到数据库
				int row = foodDao.addFood(f);
				if (row != 0) {
					response.sendRedirect("back/default.jsp");
				}else {
					response.sendRedirect("back/error.html");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (action.equals("toUpdateFood")){
            int fid = Integer.parseInt(request.getParameter("fid"));
            Food food = foodDao.getFoodByID(fid);
            request.setAttribute("food",food);
            request.getRequestDispatcher("back/updateFood.jsp").forward(request,response);

        }else if (action.equals("doUpdateFood")){
            // 为解析类提供配置信息
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 创建解析类的实例
            ServletFileUpload sfu = new ServletFileUpload(factory);
            // 开始解析
            sfu.setFileSizeMax(1024 * 1024 * 10);
            // 每个表单域中数据会封装到一个对应的FileItem对象上
            try {
                List<FileItem> items = sfu.parseRequest(request);
                // 区分表单域
                int fid = 0;
                String fileName = "";
                String foodName = "";
                int fsellCount = 0;
                String fimage = "";

                float fprice = 0;
                for (int i = 0; i < items.size(); i++) {
                    FileItem item = items.get(i);
                    // isFormField为true，表示这不是文件上传表单域
                    if (!item.isFormField()) {
                        ServletContext sctx = getServletContext();
                        // 获得存放文件的物理路径
                        // upload下的某个文件夹 得到当前在线的用户 找到对应的文件夹

                        String path = sctx.getRealPath("/foodImg");
                        System.out.println(path);
                        // 获得文件名
                        fileName = item.getName();
                        System.out.println(fileName);
                        // 该方法在某些平台(操作系统),会返回路径+文件名
                        fileName = fileName
                                .substring(fileName.lastIndexOf("/") + 1);
                        File file = new File(path + "\\" + fileName);
                        if (!file.exists()) {
                            item.write(file);
                            // 将上传图片的名字记录到数据库中
                        }
                    }else{
                        if("fid".equals(item.getFieldName())){
                            fid = Integer.parseInt(item.getString("utf-8").trim());
                        }
                        if("fname".equals(item.getFieldName())){
                            foodName = item.getString("utf-8").trim();
                        }
                        if("fsellCount".equals(item.getFieldName())){
                            fsellCount = Integer.parseInt(item.getString("utf-8").trim());
                        }
                        if("fprice".equals(item.getFieldName())){
                            fprice = Float.parseFloat(item.getString("utf-8").trim());
                        }
						if("fimage".equals(item.getFieldName())){
							fimage = item.getString("utf-8").trim();
						}
                    }
                }

				//构建Food实体类
				Food f;
				if (fileName == null || fileName.equals("")){
                	f = new Food(fid,foodName,fprice,fsellCount,fimage);
				}else {
					f = new Food(fid,foodName,fprice,fsellCount,fileName);
				}
                //添加到数据库
                int row = foodDao.updateFood(f);
                if (row != 0) {
                    response.sendRedirect("back/default.jsp");
                }else {
                    response.sendRedirect("back/error.html");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if(action.equals("queryAllFoods")){
			List<Food> foodList = foodDao.getAllFood();
			request.setAttribute("foodList",foodList);
			request.getRequestDispatcher("front/index.jsp").forward(request,response);
		}else if (action.equals("deleteFood")){
            int fid = Integer.parseInt(request.getParameter("fid"));
            foodDao.deleteFood(fid);

            request.getRequestDispatcher("back/default.jsp").forward(request,response);
        }

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
