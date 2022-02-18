package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jxls.area.Area;
import org.jxls.builder.xls.XlsCommentAreaBuilder;
import org.jxls.common.Context;
import org.jxls.transform.poi.PoiTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

	@Autowired
	private Data data;

	public void transform() {

		System.out.println(data);

		try {
			InputStream is = new FileInputStream(new File(
					"/Users/momalliped/Documents/workspace-spring-tool-suite-4-4.13.1.RELEASE/demo/src/main/java/com/example/demo/test.xlsx"));

			OutputStream os = new FileOutputStream(new File(
					"/Users/momalliped/Documents/workspace-spring-tool-suite-4-4.13.1.RELEASE/demo/src/main/java/com/example/demo/output.xlsx"));

			Context context = new Context();
			context.putVar("employees", data.getEmps());
			context.putVar("departments", data.getDepts());

			// JxlsHelper.getInstance().processTemplate(is, os, context);

			Workbook workBook = WorkbookFactory.create(is);
			PoiTransformer transformer = PoiTransformer.createTransformer(workBook);
			transformer.setOutputStream(os);

			XlsCommentAreaBuilder areaBuilder = new XlsCommentAreaBuilder(transformer, false);
			List<Area> areas = areaBuilder.build();

			areas.forEach(a -> {
				a.applyAt(a.getStartCellRef(), context);
				a.processFormulas();
			});
			
			transformer.write();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
