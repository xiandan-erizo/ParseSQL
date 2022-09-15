package cn.ekuaibao.sqlparse;

import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.visitor.ParameterizedOutputVisitorUtils;

public class SQLParseSingle {

    private SQLParseSingle() {
    }

    private static final SQLParseSingle sqlParseSingle = new SQLParseSingle();

    public static SQLParseSingle getInstance() {
        return sqlParseSingle;
    }

    /**
     * 使用druid特征化SQL
     *
     * @param sql    sql
     * @param dbType 数据库类型
     * @return 特征化的SQL
     */
    public String paramSQL(String sql, String dbType) {
        return ParameterizedOutputVisitorUtils.parameterize(sql, DbType.valueOf(dbType));

    }


}