package com.xmg.touna.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileHelper {

	/**
	 * 递归删除目录下的所有文件及子目录下所有文件
	 * 
	 * @param dir
	 *            将要删除的文件目录
	 * @return boolean Returns "true" if all deletions were successful. If a
	 *         deletion fails, the method stops attempting to delete and returns
	 *         "false".
	 */
	public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }

	/**
	 * 删除空目录
	 * 
	 * @param dir
	 *            将要删除的目录路径
	 */
	public static void doDeleteEmptyDir(String dir) {
		boolean success = (new File(dir)).delete();
		if (success) {
			System.out.println("Successfully deleted empty directory: " + dir);
		} else {
			System.out.println("Failed to delete empty directory: " + dir);
		}
	}
	
	/**
	 * 拷贝文件
	 * @param file
	 * @param file2
	 */
	public static boolean copyFile(File inFile, File outFile) {
		try {
			FileInputStream inputStream =new FileInputStream(inFile);
			FileOutputStream  outputStream=new FileOutputStream(outFile);
			 byte[] buffer=new byte[1024];
			 int num=0;
			  while((num=inputStream.read(buffer))!=-1){
				  outputStream.write(buffer,0,num);
			  }
			  inputStream.close();
			  outputStream.flush();
			  outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	/**
	 * 测试
	 */
//	public static void main(String[] args) {
//		doDeleteEmptyDir("new_dir1");
//		String newDir2 = "new_dir2";
//		boolean success = deleteDir(new File(newDir2));
//		if (success) {
//			System.out.println("Successfully deleted populated directory: " + newDir2);
//		} else {
//			System.out.println("Failed to delete populated directory: " + newDir2);
//		}
//	}
}
