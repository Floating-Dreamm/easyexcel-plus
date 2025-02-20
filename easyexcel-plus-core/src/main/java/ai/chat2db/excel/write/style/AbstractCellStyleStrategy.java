package ai.chat2db.excel.write.style;

import ai.chat2db.excel.write.handler.CellWriteHandler;
import ai.chat2db.excel.write.handler.context.CellWriteHandlerContext;
import ai.chat2db.excel.constant.OrderConstant;
import ai.chat2db.excel.metadata.Head;

import org.apache.poi.ss.usermodel.Cell;

/**
 * Cell style strategy
 *
 * @author Jiaju Zhuang
 */
public abstract class AbstractCellStyleStrategy implements CellWriteHandler {

    @Override
    public int order() {
        return OrderConstant.DEFINE_STYLE;
    }

    @Override
    public void afterCellDispose(CellWriteHandlerContext context) {
        if (context.getHead() == null) {
            return;
        }
        if (context.getHead()) {
            setHeadCellStyle(context);
        } else {
            setContentCellStyle(context);
        }
    }

    /**
     * Sets the cell style of header
     *
     * @param context
     */
    protected void setHeadCellStyle(CellWriteHandlerContext context) {
        setHeadCellStyle(context.getCell(), context.getHeadData(), context.getRelativeRowIndex());
    }

    /**
     * Sets the cell style of header
     *
     * @param cell
     * @param head
     * @param relativeRowIndex
     */
    protected void setHeadCellStyle(Cell cell, Head head, Integer relativeRowIndex) {
        throw new UnsupportedOperationException("Custom styles must override the setHeadCellStyle method.");
    }

    /**
     * Sets the cell style of content
     *
     * @param context
     */
    protected void setContentCellStyle(CellWriteHandlerContext context) {
        setContentCellStyle(context.getCell(), context.getHeadData(), context.getRelativeRowIndex());
    }

    /**
     * Sets the cell style of content
     *
     * @param cell
     * @param head
     * @param relativeRowIndex
     */
    protected void setContentCellStyle(Cell cell, Head head, Integer relativeRowIndex) {
        throw new UnsupportedOperationException("Custom styles must override the setContentCellStyle method.");
    }

}
