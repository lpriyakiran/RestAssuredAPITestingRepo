package com.test.utils;

import com.test.constatnts.SourcePath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utils {

	public static String getConfigProperty(String key) {
		
		Properties properties = new Properties();
		String filePath = SourcePath.CONFIG_FILE_PATH;

		FileInputStream inputfile = null;
		try {
			inputfile = new FileInputStream(filePath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String value = null;

		try {
			try {
				properties.load(inputfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			value = properties.getProperty(key);
		} finally {
			try {
				inputfile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		return value;
	}
}
