package com.blogspot.vardlokkur.httpmessageconverter;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Warlock
 */
@Service
public class TeamToXlsConverter extends AbstractHttpMessageConverter<Team> {

    private static final MediaType EXCEL_TYPE = MediaType.valueOf("application/vnd.ms-excel");

    TeamToXlsConverter() {
        super(EXCEL_TYPE);
    }

    @Override
    protected Team readInternal(final Class<? extends Team> clazz, final HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected boolean supports(final Class<?> clazz) {
        return (Team.class == clazz);
    }

    @Override
    protected void writeInternal(final Team team, final HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        try (final Workbook workbook = new HSSFWorkbook()) {
            final Sheet sheet = workbook.createSheet();
            int rowNo = 0;
            for (final TeamMember member : team.getMembers()) {
                final Row row = sheet.createRow(rowNo++);
                row.createCell(0)
                   .setCellValue(member.getName());
            }
            workbook.write(outputMessage.getBody());
        }
    }

}
