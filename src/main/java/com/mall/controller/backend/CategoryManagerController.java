package com.mall.controller.backend;

import com.mall.common.Const;
import com.mall.common.ResponseCodeEnum;
import com.mall.common.ServerResponse;
import com.mall.pojo.Category;
import com.mall.pojo.User;
import com.mall.service.ICategoryService;
import com.mall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by peter on 17/9/11.
 */
@Controller
@RequestMapping("/manage/category/")
public class CategoryManagerController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICategoryService iCategoryService;


    /**
     * 新增品类信息
     * @param session
     * @param categoryName
     * @param parentId
     * @return
     */
    @RequestMapping(value = "add_category.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse addCategory(HttpSession session, String categoryName, @RequestParam(value = "parentId", defaultValue = "0") int parentId) {
        //判断用户是否登录
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(), "用户未登录");
        }
        //判断用户是管理员账户
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //是管理员,新增分类
            return iCategoryService.addCategory(categoryName, parentId);

        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
        }
    }


    /**
     *更新品类名称
     * @param categoryId
     * @param categoryName
     * @return
     */
    @RequestMapping(value = "set_category_name.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse updateCategory(Integer categoryId, String categoryName) {
        return iCategoryService.updateCategory(categoryId, categoryName);
    }


    /**
     * 查找平级分类信息,不递归
     * @param session
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "get_category.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getChildrenParallelCategory(HttpSession session, @RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId){
        //判断用户是否登录
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(), "用户未登录");
        }
        //判断用户是管理员账户
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //是管理员,新增分类
            return iCategoryService.getChildrenParallelCategory(categoryId);

        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
        }
    }

    /**
     * 查找分类信息,递归
     * @param session
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "get_deep_category.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getCategoryAndDeepChildrenCategory(HttpSession session, @RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId) {
        //判断用户是否登录
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(), "用户未登录");
        }
        //判断用户是管理员账户
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //查找当前节点的id和子节点的id,1-->100-->1000
            return iCategoryService.getCategoryAndDeepChildrenCategory(categoryId);

        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
        }



    }


}
