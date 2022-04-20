package com.lonch.game.request;

import com.lonch.game.dto.OpenGameDto;

import java.io.Serializable;

/**
 * @description:
 * @author: lpx
 * @create: 2022-03-17 09:43
 */
public class OpenGameRequest extends BaseRequest implements Serializable {

    public OpenGameDto param;

    public OpenGameDto getParam() {
        return param;
    }

    public void setParam(OpenGameDto param) {
        this.param = param;
    }
}
