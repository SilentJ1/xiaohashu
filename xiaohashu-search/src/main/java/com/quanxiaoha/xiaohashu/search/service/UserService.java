package com.quanxiaoha.xiaohashu.search.service;

import com.quanxiaoha.framework.common.response.PageResponse;
import com.quanxiaoha.xiaohashu.search.model.vo.SearchUserReqVO;
import com.quanxiaoha.xiaohashu.search.model.vo.SearchUserRspVO;


public interface UserService {

    /**
     * 搜索用户
     *
     * @param searchUserReqVO
     * @return
     */
    PageResponse<SearchUserRspVO> searchUser(SearchUserReqVO searchUserReqVO);
}

