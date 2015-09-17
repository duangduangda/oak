import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

public class FileUtil{
	
	private static Logger logger = Logger.getLogger(FileUtil.class);
	/**
	 * 
	 * @Description: 生成文件
	 * @author duangduangda
	 * @since 2015年7月23日
	 * @param fileName
	 * @param data
	 * @param template
	 * @return
	 */
	public static File createTextToFile(String fileName){
		File file = new File(fileName);
		try {
			if(file.exists()){
				return null;
			}else{
				file.getParentFile().mkdirs();
				file.createNewFile();
				logger.debug("============================"+file.getName()+"被创建,完整路径为"+file.getAbsolutePath());
			}
		} catch (Exception e){
			logger.error(e);
		}
		return file;
	}

	/**
	 * @Description: 压缩文件
	 * @author duangduangda
	 * @since 2015年7月23日
	 * @param file
	 * @param out
	 * @throws Exception
	 */
	public static void compressFile(File file, ZipOutputStream out) {
		if (!file.exists()) {
			return;
		}
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ZipEntry entry = new ZipEntry(file.getName());
			out.putNextEntry(entry);
			int count;
			byte data[] = new byte[8192];
			while ((count = bis.read(data, 0, 8192)) != -1) {
				out.write(data, 0, count);
			}
		} catch (Exception e) {
			logger.error(e);
		}finally{
			try {
				if(null != fis){
					fis.close();
				}
				if(null != bis){
					bis.close();
				}
				System.gc();
			} catch (IOException ex) {
				logger.error(ex);
			}
		}
	}
	
	/**
	 * @Description: 删除临时文件夹
	 * @author duangduangda
	 * @since 2015年7月24日
	 * @param file
	 */
	public static void deleteFile(File file) {
		boolean flag = false;
		if (file.exists()) {
			if (file.isFile()) {
				flag = file.delete();
				if(flag){
					logger.debug("==============================================="+file.getName()+"已被删除");
				}
			} else if (file.isDirectory()) {
				File files[] = file.listFiles();
				for (int i = 0; i < files.length && !flag; i++) {
					deleteFile(files[i]);
				}
				flag = file.delete();
				if(flag){
					logger.debug("==============================================="+file.getName()+"已被删除");
				}
			}
		} else {
			logger.error("所删除的文件不存在！" + '\n');
		}
	}
}
