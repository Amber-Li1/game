package com.lonch.game.request;


import com.lonch.game.dto.ChooseColorDto;

import java.io.Serializable;

/**
 * @description: 选择颜色
 * @author: lpx
 * @create: 2022-03-16 17:55
 */
public class ChooseColorRequest extends BaseRequest implements Serializable {

        public ChooseColorDto param;

        public ChooseColorDto getParam() {
                return param;
        }

        public void setParam(ChooseColorDto param) {
                this.param = param;
        }
}
