package com.quanxiaoha.xiaohashu.search.service;

import com.quanxiaoha.framework.common.response.PageResponse;
import com.quanxiaoha.xiaohashu.search.model.vo.SearchNoteReqVO;
import com.quanxiaoha.xiaohashu.search.model.vo.SearchNoteRspVO;

public interface NoteService {

    /**
     * 搜索笔记
     *
     * @param searchNoteReqVO
     * @return
     */
    PageResponse<SearchNoteRspVO> searchNote(SearchNoteReqVO searchNoteReqVO);
}

