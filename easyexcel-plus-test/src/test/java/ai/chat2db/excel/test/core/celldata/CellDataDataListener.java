package ai.chat2db.excel.test.core.celldata;

import java.util.ArrayList;
import java.util.List;

import ai.chat2db.excel.event.AnalysisEventListener;
import ai.chat2db.excel.context.AnalysisContext;
import ai.chat2db.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson2.JSON;

import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jiaju Zhuang
 */
public class CellDataDataListener extends AnalysisEventListener<CellDataReadData> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CellDataDataListener.class);
    List<CellDataReadData> list = new ArrayList<>();

    @Override
    public void invoke(CellDataReadData data, AnalysisContext context) {
        list.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        Assertions.assertEquals(list.size(), 1);
        CellDataReadData cellDataData = list.get(0);

        Assertions.assertEquals("2020年01月01日", cellDataData.getDate().getData());
        Assertions.assertEquals((long)cellDataData.getInteger1().getData(), 2L);
        Assertions.assertEquals((long)cellDataData.getInteger2(), 2L);
        if (context.readWorkbookHolder().getExcelType() != ExcelTypeEnum.CSV) {
            Assertions.assertEquals(cellDataData.getFormulaValue().getFormulaData().getFormulaValue(), "B2+C2");
        } else {
            Assertions.assertNull(cellDataData.getFormulaValue().getData());
        }
        LOGGER.debug("First row:{}", JSON.toJSONString(list.get(0)));
    }
}
