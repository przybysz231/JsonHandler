package com.Michal.HomeworkTask.parameter;

import com.Michal.HomeworkTask.exception.ParamNotFoundException;

public class Param {
    private static String param;
    public static String setParam() {
        return param;
    }
    public static void setParam(String param)
    {
        if (param == null)
        {
            throw new ParamNotFoundException();
        }

        Param.param = param;
    }
}
