package ai.chat2db.excel.write.metadata.holder;

import ai.chat2db.excel.enums.HolderEnum;
import ai.chat2db.excel.write.metadata.WriteTable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * sheet holder
 *
 * @author Jiaju Zhuang
 */
@Getter
@Setter
@EqualsAndHashCode
public class WriteTableHolder extends AbstractWriteHolder {
    /***
     * poi sheet
     */
    private WriteSheetHolder parentWriteSheetHolder;
    /***
     * tableNo
     */
    private Integer tableNo;
    /**
     * current table param
     */
    private WriteTable writeTable;

    public WriteTableHolder(WriteTable writeTable, WriteSheetHolder writeSheetHolder) {
        super(writeTable, writeSheetHolder);
        this.parentWriteSheetHolder = writeSheetHolder;
        this.tableNo = writeTable.getTableNo();
        this.writeTable = writeTable;

        // init handler
        initHandler(writeTable, writeSheetHolder);
    }

    @Override
    public HolderEnum holderType() {
        return HolderEnum.TABLE;
    }
}
