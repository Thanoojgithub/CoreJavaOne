package com.corejava.file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class ByteArrayToFile {

	@Test
	public void convert_byte_array_to_file_java() throws IOException {
		byte[] fileAsByteArray = { 70, 105, 108, 101, 32, 116, 111, 32, 98, 121, 116, 101, 32, 97, 114, 114, 97, 121 };
		File file = new File("temp/test.xml");
		FileUtils.writeByteArrayToFile(file, fileAsByteArray);
	}
}
