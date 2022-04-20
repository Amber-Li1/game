package com.lonch.game.request;

import com.lonch.game.dto.PutChessDto;

import java.io.Serializable;

/**
 * @description:
 * @author: lpx
 * @create: 2022-03-17 09:32
 */
public class PutChessRequest extends BaseRequest implements Serializable {

    public PutChessDto param;

    public PutChessDto getParam() {
        return param;
    }

    public void setParam(PutChessDto param) {
        this.param = param;
    }
}
