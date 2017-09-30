package com.mall.service;

import com.mall.common.ServerResponse;
import com.mall.vo.CartVO;

/**
 * Created by peter on 17/9/28.
 */
public interface ICartService {

    ServerResponse<CartVO> list(Integer userId);

    ServerResponse<CartVO> add(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVO> update(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVO> remove(Integer userId, String productIds);

    ServerResponse<CartVO> selectOrUnSelect(Integer userId, Integer productId, Integer checked);

    ServerResponse<Integer> getCartProductCount(Integer userId);








}
