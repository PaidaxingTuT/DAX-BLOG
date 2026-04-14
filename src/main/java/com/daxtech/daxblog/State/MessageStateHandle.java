package com.daxtech.daxblog.State;

import com.daxtech.daxblog.enums.StateEnum;
import com.daxtech.daxblog.response.Response;

public interface MessageStateHandle {

    StateEnum  getState();

    Response<String> handle(String message);


}
