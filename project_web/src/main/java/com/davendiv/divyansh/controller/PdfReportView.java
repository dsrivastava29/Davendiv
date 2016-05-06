package com.davendiv.divyansh.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.davendiv.divyansh.DAO.UsersDAO;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class PdfReportView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Map<String, String>> alldata = (List<Map<String, String>>) model.get("alldata");

		Table table = new Table(alldata.size());

		for (Map<String, String> row : alldata) {
			table.addColumns(row.size());
			for (Map.Entry<String, String> entry : row.entrySet()) {
				// prepS.setString(rowNo, String.valueOf(entry.getValue()));
				table.addCell(entry.getKey());
				table.addCell(entry.getValue());
			}

		}

	}

}