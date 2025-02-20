package ai.chat2db.excel.test.core.converter;

import java.math.BigDecimal;

import ai.chat2db.excel.converters.WriteConverterContext;
import ai.chat2db.excel.converters.floatconverter.FloatNumberConverter;
import ai.chat2db.excel.metadata.data.WriteCellData;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author Jiaju Zhuang
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class ConverterTest {

    @Test
    public void t01FloatNumberConverter() {
        FloatNumberConverter floatNumberConverter = new FloatNumberConverter();
        WriteConverterContext<Float> context = new WriteConverterContext<>();
        context.setValue(95.62F);
        WriteCellData<?> writeCellData = floatNumberConverter.convertToExcelData(context);
        Assertions.assertEquals(0, writeCellData.getNumberValue().compareTo(new BigDecimal("95.62")));
    }

}
