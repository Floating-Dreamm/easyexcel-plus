package ai.chat2db.excel.test.core.fill.annotation;

import java.util.Date;

import ai.chat2db.excel.annotation.ExcelProperty;
import ai.chat2db.excel.annotation.format.DateTimeFormat;
import ai.chat2db.excel.annotation.format.NumberFormat;
import ai.chat2db.excel.annotation.write.style.ContentLoopMerge;
import ai.chat2db.excel.annotation.write.style.ContentRowHeight;
import ai.chat2db.excel.converters.string.StringImageConverter;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jiaju Zhuang
 */
@Getter
@Setter
@EqualsAndHashCode
@ContentRowHeight(100)
public class FillAnnotationData {
    @ExcelProperty("日期")
    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    private Date date;

    @ExcelProperty(value = "数字")
    @NumberFormat("#.##%")
    private Double number;

    @ContentLoopMerge(columnExtend = 2)
    @ExcelProperty("字符串1")
    private String string1;
    @ExcelProperty("字符串2")
    private String string2;
    @ExcelProperty(value = "图片", converter = StringImageConverter.class)
    private String image;
}
