package com.cobra.sell.utils;

import com.cobra.sell.vo.ResultVO;

/**
 * @Author: Baron
 * @Description: 返回前端的对象工具类
 * @Date: Created in 2019/1/9 19:38
 */
public class ResultVOUtil {

    /**
     * 成功
     *
     * @param object
     * @return
     */
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    /**
     * @return
     */
    public static ResultVO success() {
        return success(null);
    }

    /**
     * 失败
     *
     * @param code
     * @param msg
     * @return
     */
    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

}
