package ai.chat2db.excel.test.temp;

import java.util.ArrayList;
import java.util.List;

import ai.chat2db.excel.context.AnalysisContext;
import ai.chat2db.excel.event.AnalysisEventListener;
import ai.chat2db.excel.test.demo.read.DemoDataListener;
import com.alibaba.fastjson2.JSON;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 模板的读取类
 *
 * @author Jiaju Zhuang
 */
public class LockDataListener extends AnalysisEventListener<LockData> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoDataListener.class);
    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<LockData> list = new ArrayList<LockData>();

    @Override
    public void invoke(LockData data, AnalysisContext context) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
        list.add(data);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        LOGGER.info("存储数据库成功！");
    }
}
