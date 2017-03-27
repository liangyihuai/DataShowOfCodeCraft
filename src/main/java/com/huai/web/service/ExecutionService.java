package com.huai.web.service;

import com.huai.web.DataSetException;
import com.huai.web.pojo.DataSet;
import com.huai.web.pojo.Result;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by liangyh on 3/14/17.
 */

public interface ExecutionService {
    Result judgeResultSet(InputStream inputOfDataSet, InputStream inputOfResultSet);
    DataSet parseDataSet(InputStream inputStream) throws DataSetException, IOException;
}
