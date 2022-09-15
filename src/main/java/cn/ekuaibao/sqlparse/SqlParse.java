package cn.ekuaibao.sqlparse;

import cn.ekuaibao.entity.SlowSqlRecord;
import cn.ekuaibao.util.HashUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SqlParse extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // 中文乱码问题
            req.setCharacterEncoding("utf8");
            ServletInputStream inputStream = req.getInputStream();
            // 从body中获取所有数据
            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];

            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            // 大小写转换
            TypeUtils.compatibleWithJavaBean = true;
            outSteam.close();
            inputStream.close();
            String re = new String(outSteam.toByteArray(), "UTF-8");
            List<SlowSqlRecord> slowSqlRecordList = JSONObject.parseArray(re, SlowSqlRecord.class);
            ArrayList<SlowSqlRecord> resultList = new ArrayList<SlowSqlRecord>();
            for (SlowSqlRecord slowSqlRecord : slowSqlRecordList) {
                String sql = slowSqlRecord.getSQLText();
                String result = SQLParseSingle.getInstance().paramSQL(sql, "mysql");
                slowSqlRecord.setSqlTemplate(result);
                slowSqlRecord.setSQLHash(HashUtil.hashKeyForDisk(result));
                resultList.add(slowSqlRecord);
            }
            String result = JSONObject.toJSONString(resultList);
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print(result);
            out.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
