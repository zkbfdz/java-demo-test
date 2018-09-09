package com.zhukai.pattern.template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyJDBCTemplate {

    private DataSource dataSource;

    public MyJDBCTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> excuteQuery(String sql, Object[] values, RowMapper rowMapper) throws SQLException {

        // 获取连接
        Connection connection = dataSource.getConnection();

        // 获取sql预处理对象
        PreparedStatement ps = connection.prepareStatement(sql);

        // 执行
        ResultSet resultSet = this.excute(ps, values);

        // 解析结果
        List<?> result = this.parseResult(resultSet, rowMapper);

        // 关闭连接
        connection.close();
        ps.close();
        resultSet.close();

        return result;
    }

    private ResultSet excute(PreparedStatement ps, Object[] value) throws SQLException {
        for (int i = 0; i < value.length; i++) {
            ps.setObject(i+1, value[i]);
        }
        return ps.executeQuery();
    }

    private List<?> parseResult(ResultSet resultSet, RowMapper rowMapper) throws SQLException {
        List<Object> resultList = new ArrayList<>();
        while (resultSet.next()) {
            resultList.add(rowMapper.mapRow(resultSet));
        }
        return resultList;
    }
}
