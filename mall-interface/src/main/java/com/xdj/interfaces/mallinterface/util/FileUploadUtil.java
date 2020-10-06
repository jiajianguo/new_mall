package com.xdj.interfaces.mallinterface.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @author Administrator
 */
public class FileUploadUtil {

	public static final String imgPath (String path) {
		final String line = File.separator;
		String imgPath = null;
		if("/".equals(line)) {
			imgPath = new String ("/home/imagess/"+path);
		}else if("\\".equals(line)) {
			imgPath = new String ("D:\\Web_Food\\imagess\\"+path);
		}
		return imgPath;
	}

	public static final String returnUrlHandle(String path) {
		final String line = File.separator;
		String imgPath = null;
		if(path != null && path.isEmpty()) {
			if("/".equals(line)) {
				imgPath = path.replace("/home", "");
			}else if("\\".equals(line)) {
				imgPath = path.replace("C:\\Web_Food\\imagess", "");
			}
		}
		return imgPath;
	}
	public static final String imgPaths (String path) {
		final String line = File.separator;
		String imgPath = null;
		if("/".equals(line)) {
			imgPath = new String ("/home/imagess/"+path+"/");
		}else if("\\".equals(line)) {
			imgPath = new String ("C:\\Web_Food\\imagess\\"+path+"\\");
		}
		return imgPath;
	}

	public static final String fileUpload(MultipartFile file,String file_path) {
        // 先判断文件是否为空
		 String path = null;
        if (!file.isEmpty()) {
            // 重命名文件
            path = System.currentTimeMillis() + String.valueOf(".jpg");
            // 项目下相对路径
            String filePath = file_path + path;
            // 创建文件实例
            File tempFile = new File(filePath);
            // 判断父级目录是否存在，不存在则创建
            if (!tempFile.getParentFile().exists()) {
            	tempFile.getParentFile().mkdirs();
            }
            // 判断文件是否存在，否则创建文件（夹）
            if (!tempFile.exists()) {
                tempFile.mkdir();
            }
            try {
                // 将接收的文件保存到指定文件中
                file.transferTo(tempFile);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return path;
    }


	public  final static void photoHandleByWidthAndHeight(MultipartFile file,String file_path,String name, int height, int width, boolean b) {
		// 先判断文件是否为空
		 if (!file.isEmpty() ) {
            // 重命名文件
            // 项目下相对路径
            String filePath = file_path+name ;
            // 创建文件实例
            File tempFile = new File(filePath);
            // 判断父级目录是否存在，不存在则创建
            if (!tempFile.getParentFile().exists()) {
            	tempFile.getParentFile().mkdirs();
            }
            // 判断文件是否存在，否则创建文件（夹）
            /*if ( !tempFile.exists()) {
            	tempFile.mkdir();
            }*/

            try {
            	// 将接收的文件保存到指定文件中
            	file.transferTo(tempFile);
            } catch (IllegalStateException e) {
            	e.printStackTrace();
            } catch (IOException e) {
            	e.printStackTrace();
            }
            ImageUtils.scaleByWidthAndHeight(tempFile, filePath, height, width, b);
        }
    }

	public static void main(String[] args) {
		 /*FileItem fileItem = createFileItem("C:\\Users\\Administrator\\Desktop\\20.jpg");
	     MultipartFile mfile = new CommonsMultipartFile(fileItem);
		 photoHandleByWidthAndHeight(mfile,"C:\\Users\\Administrator\\Desktop\\","1314.jpg",180,180,false);*/
	}


	private static FileItem createFileItem(String filePath)
    {
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        String textFieldName = "textField";
        int num = filePath.lastIndexOf(".");
        String extFile = filePath.substring(num);
        FileItem item = factory.createItem(textFieldName, "text/plain", true,
            "MyFileName" + extFile);
        File newfile = new File(filePath);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        try
        {
            FileInputStream fis = new FileInputStream(newfile);
            OutputStream os = item.getOutputStream();
            while ((bytesRead = fis.read(buffer, 0, 8192))
                != -1)
            {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            fis.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return item;
    }

	/**
	 * 多文件上传，方式二：利用MultipartHttpServletRequest来解析Request中的文件
	 * 用 transferTo方法来保存图片，保存到本地磁盘。
	 * @author chunlynn
	 */
	public static String mangFileUpload(List<MultipartFile> files,String file_path){
	      for (MultipartFile file : files) { //循环遍历，取出单个文件，下面的操作和单个文件就一样了
	          if (!file.isEmpty()) { //这个判断必须要加
	               // 获得原始文件名
	               String fileName = file.getOriginalFilename();
	               String newfileName =System.currentTimeMillis() + String.valueOf(fileName);
	               // 项目下相对路径
	               String path = file_path + newfileName;
	               // 创建文件实例
	               File tempFile = new File( path); //文件保存路径为pathRoot + path
	               if (!tempFile.getParentFile().exists()) {
	                    tempFile.getParentFile().mkdir();
	               }
	               if (!tempFile.exists()) {
	                   tempFile.mkdir();
	               }
	               try {
	                    file.transferTo(tempFile);
	               } catch (IllegalStateException e) {
	                     e.printStackTrace();
	               } catch (IOException e) {
	                     e.printStackTrace();
	               }
	            }
	        }
	        return "upload";
	    }
	public static String defaultPath(String path) {
		// TODO Auto-generated method stub
		final String line = File.separator;
		String imgPath = null;
		if("/".equals(line)) {
			imgPath = new String ("/home/imagess/"+path+"/default.mp3");
		}else if("\\".equals(line)) {
			imgPath = new String ("C:\\Web_Food\\imagess\\"+path+"\\default.mp3");
		}
		return imgPath;
	}

}
