package com.mall.controller.portal;

import com.mall.common.ServerResponse;
import com.mall.pojo.Shipping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by peter on 17/9/30.
 */
@Controller
@RequestMapping("/shipping/")
public class ShippingController {


    /**
     * 添加地址
     * @param session
     * @param shipping
     * @return
     */
    @RequestMapping("add.do")
    @ResponseBody
    public ServerResponse add(HttpSession session, Shipping shipping) {

        return null;


    }

    /**
     * 删除地址
     * @param session
     * @param shippingId
     * @return
     */
    @RequestMapping("del.do")
    @ResponseBody
    public ServerResponse delete(HttpSession session, Integer shippingId) {
        return null;

    }

    /**
     * 登录状态更新地址
     * @param session
     * @param shipping
     * @return
     */
    @RequestMapping("update.do")
    @ResponseBody
    public ServerResponse update(HttpSession session, Shipping shipping) {
        return null;

    }

    /**
     * 选中查看具体的地址
     * @param session
     * @param shippingId
     * @return
     */
    @RequestMapping("select.do")
    @ResponseBody
    public ServerResponse select(HttpSession session, Integer shippingId) {

        return null;
    }


    /**
     * 地址列表
     * @param session
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse select(HttpSession session,
                                 @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

        return null;
    }
}
