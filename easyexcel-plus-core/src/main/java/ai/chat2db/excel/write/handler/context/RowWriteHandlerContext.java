package ai.chat2db.excel.write.handler.context;

import ai.chat2db.excel.context.WriteContext;
import ai.chat2db.excel.write.metadata.holder.WriteSheetHolder;
import ai.chat2db.excel.write.metadata.holder.WriteTableHolder;
import ai.chat2db.excel.write.metadata.holder.WriteWorkbookHolder;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Row;

/**
 * row context
 *
 * @author Jiaju Zhuang
 */
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class RowWriteHandlerContext {
    /**
     * write context
     */
    private WriteContext writeContext;
    /**
     * workbook
     */
    private WriteWorkbookHolder writeWorkbookHolder;
    /**
     * sheet
     */
    private WriteSheetHolder writeSheetHolder;
    /**
     * table .Nullable.It is null without using table writes.
     */
    private WriteTableHolder writeTableHolder;
    /**
     * row index
     */
    private Integer rowIndex;
    /**
     * row
     */
    private Row row;
    /**
     * Nullable.It is null in the case of fill data.
     */
    private Integer relativeRowIndex;
    /**
     * Nullable.It is null in the case of fill data.
     */
    private Boolean head;
}
