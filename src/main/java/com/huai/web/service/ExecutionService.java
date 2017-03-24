package com.huai.web.service;

import com.huai.web.pojo.DataSet;

import java.io.InputStream;

/**
 * Created by liangyh on 3/14/17.
 */

public interface ExecutionService {
    boolean judgeResultSet(InputStream inputOfDataSet, InputStream inputOfResultSet);
    DataSet parseDataSet(InputStream inputStream);
}
