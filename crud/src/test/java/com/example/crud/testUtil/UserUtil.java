package com.example.crud.testUtil;

import com.example.crud.dto.SubmitReadingInterval;

public class UserUtil {

    public static SubmitReadingInterval createSubmitInterval(){
        SubmitReadingInterval submitReadingInterval = new SubmitReadingInterval();
        submitReadingInterval.setStartInterval(1);
        submitReadingInterval.setEndInterval(10);
        submitReadingInterval.setBookId(1);
        return submitReadingInterval;
    }
}
