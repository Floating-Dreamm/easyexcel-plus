package ai.chat2db.excel.read.metadata.holder;

import java.util.LinkedHashMap;
import java.util.Map;

import ai.chat2db.excel.enums.HolderEnum;
import ai.chat2db.excel.read.metadata.ReadSheet;
import ai.chat2db.excel.metadata.Cell;
import ai.chat2db.excel.metadata.CellExtra;
import ai.chat2db.excel.metadata.data.ReadCellData;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * sheet holder
 *
 * @author Jiaju Zhuang
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class ReadSheetHolder extends AbstractReadHolder {

    /**
     * current param
     */
    private ReadSheet readSheet;
    /***
     * parent
     */
    private ReadWorkbookHolder parentReadWorkbookHolder;
    /***
     * sheetNo
     */
    private Integer sheetNo;
    /***
     * sheetName
     */
    private String sheetName;
    /**
     * Gets the total number of rows , data may be inaccurate
     */
    private Integer approximateTotalRowNumber;
    /**
     * Data storage of the current row.
     */
    private Map<Integer, Cell> cellMap;
    /**
     * Data storage of the current extra cell.
     */
    private CellExtra cellExtra;
    /**
     * Index of the current row.
     */
    private Integer rowIndex;
    /**
     * Current CellData
     */
    private ReadCellData<?> tempCellData;
    /**
     * Read the size of the largest head in sheet head data.
     * see https://github.com/CodePhiliaX/easyexcel-plus/issues/2014
     */
    private Integer maxNotEmptyDataHeadSize;

    /**
     * Reading this sheet has ended.
     */
    private Boolean ended;

    public ReadSheetHolder(ReadSheet readSheet, ReadWorkbookHolder readWorkbookHolder) {
        super(readSheet, readWorkbookHolder);
        this.readSheet = readSheet;
        this.parentReadWorkbookHolder = readWorkbookHolder;
        this.sheetNo = readSheet.getSheetNo();
        this.sheetName = readSheet.getSheetName();
        this.cellMap = new LinkedHashMap<>();
        this.rowIndex = -1;
    }

    /**
     * Approximate total number of rows.
     * use: getApproximateTotalRowNumber()
     *
     * @return
     */
    @Deprecated
    public Integer getTotal() {
        return approximateTotalRowNumber;
    }

    @Override
    public HolderEnum holderType() {
        return HolderEnum.SHEET;
    }

}
