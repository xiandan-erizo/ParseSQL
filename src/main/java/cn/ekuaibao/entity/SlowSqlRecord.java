package cn.ekuaibao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * id = models.CharField("id", max_length=32, primary_key=True)
 * instance_name = models.CharField("instance_name", max_length=50)
 * sql_hash = models.CharField("慢日志明细里的SQL语句唯一标识符", max_length=64)
 * db_name = models.CharField("数据库名称。", max_length=128)
 * db_node_id = models.CharField("节点ID。", max_length=128, null=True)
 * execution_start_time = models.DateTimeField("SQL开始执行的时间")
 * host_address = models.CharField("连接数据库的客户端地址", max_length=128)
 * lock_times = models.IntegerField("锁定时长")
 * parse_row_counts = models.IntegerField("解析行数")
 * query_time_ms = models.IntegerField("执行时长ms")
 * query_time = models.IntegerField("执行时长s")
 * return_row_counts = models.IntegerField("返回行数")
 * sql_text = models.TextField("查询语句")
 * ali_type = models.CharField('阿里数据库类型', max_length=20, choices=ALI_TYPE_CHOICES, blank=True, default=None)
 */
public class SlowSqlRecord implements Serializable {
    private String DBName;
    private String DBNodeId;
    private Date ExecutionStartTime;
    private String HostAddress;
    private Integer LockTimes;
    private Integer ParseRowCounts;
    private Long QueryTimeMS;
    private Long QueryTimes;
    private Long ReturnRowCounts;
    private String SQLText;
    private String SQLTemplate;
    private String SQLHash;

    public String getSqlTemplate() {
        return SQLTemplate;
    }

    public void setSqlTemplate(String SQLTemplate) {
        this.SQLTemplate = SQLTemplate;
    }

    public String getSQLHash() {
        return SQLHash;
    }

    public void setSQLHash(String SQLHash) {
        this.SQLHash = SQLHash;
    }

    public SlowSqlRecord() {
    }

    public SlowSqlRecord(String DBName, String DBNodeId, Date executionStartTime, String hostAddress, Integer lockTimes, Integer parseRowCounts, Long queryTimeMS, Long queryTimes, Long returnRowCounts, String SQLText, String SQLHash, String SQLTemplate) {
        this.DBName = DBName;
        this.DBNodeId = DBNodeId;
        ExecutionStartTime = executionStartTime;
        HostAddress = hostAddress;
        LockTimes = lockTimes;
        ParseRowCounts = parseRowCounts;
        QueryTimeMS = queryTimeMS;
        QueryTimes = queryTimes;
        ReturnRowCounts = returnRowCounts;
        this.SQLText = SQLText;
    }

    public String getDBName() {
        return DBName;
    }

    public void setDBName(String DBName) {
        this.DBName = DBName;
    }

    public String getDBNodeId() {
        return DBNodeId;
    }

    public void setDBNodeId(String DBNodeId) {
        this.DBNodeId = DBNodeId;
    }

    public Date getExecutionStartTime() {
        return ExecutionStartTime;
    }

    public void setExecutionStartTime(Date executionStartTime) {
        ExecutionStartTime = executionStartTime;
    }

    public String getHostAddress() {
        return HostAddress;
    }

    public void setHostAddress(String hostAddress) {
        HostAddress = hostAddress;
    }

    public Integer getLockTimes() {
        return LockTimes;
    }

    public void setLockTimes(Integer lockTimes) {
        LockTimes = lockTimes;
    }

    public Integer getParseRowCounts() {
        return ParseRowCounts;
    }

    public void setParseRowCounts(Integer parseRowCounts) {
        ParseRowCounts = parseRowCounts;
    }

    public Long getQueryTimeMS() {
        return QueryTimeMS;
    }

    public void setQueryTimeMS(Long queryTimeMS) {
        QueryTimeMS = queryTimeMS;
    }

    public Long getQueryTimes() {
        return QueryTimes;
    }

    public void setQueryTimes(Long queryTimes) {
        QueryTimes = queryTimes;
    }

    public Long getReturnRowCounts() {
        return ReturnRowCounts;
    }

    public void setReturnRowCounts(Long returnRowCounts) {
        ReturnRowCounts = returnRowCounts;
    }

    public String getSQLText() {
        return SQLText;
    }

    public void setSQLText(String SQLText) {
        this.SQLText = SQLText;
    }

    @Override
    public String toString() {
        return "SlowSqlRecord{" +
                "DBName='" + DBName + '\'' +
                ", DBNodeId='" + DBNodeId + '\'' +
                ", ExecutionStartTime=" + ExecutionStartTime +
                ", HostAddress='" + HostAddress + '\'' +
                ", LockTimes=" + LockTimes +
                ", ParseRowCounts=" + ParseRowCounts +
                ", QueryTimeMS=" + QueryTimeMS +
                ", QueryTimes=" + QueryTimes +
                ", ReturnRowCounts=" + ReturnRowCounts +
                ", SQLText='" + SQLText + '\'' +
                '}';
    }
}
