package ai.chat2db.excel.converters;

import ai.chat2db.excel.context.WriteContext;
import ai.chat2db.excel.metadata.property.ExcelContentProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * write converter context
 *
 * @author Jiaju Zhuang
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class WriteConverterContext<T> {

    /**
     * Java Data.NotNull.
     */
    private T value;

    /**
     * Content property.Nullable.
     */
    private ExcelContentProperty contentProperty;

    /**
     * write context
     */
    private WriteContext writeContext;
}
