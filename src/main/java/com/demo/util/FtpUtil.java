package com.demo.util;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.model.Ftp;

public class FtpUtil {
    
    private static Logger logger=LoggerFactory.getLogger(FtpUtil.class);
    
    private static FTPClient ftp;
    
    /**
     * ��ȡftp����
     * @param f
     * @return
     * @throws Exception
     */
    public static boolean connectFtp(Ftp f) throws Exception{
        ftp=new FTPClient();
        boolean flag=false;
        int reply;
        if (f.getPort()==null) {
            ftp.connect(f.getIpAddr(),21);
        }else{
            ftp.connect(f.getIpAddr(),f.getPort());
        }
        
        ftp.login(f.getUserName(), f.getPwd());
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        reply = ftp.getReplyCode();      
        if (!FTPReply.isPositiveCompletion(reply)) {      
              ftp.disconnect();      
              return flag;      
        }      
        ftp.changeWorkingDirectory(f.getPath());      
        flag = true;      
        return flag;
    }
    
    /**
     * �ر�ftp����
     */
    public static void closeFtp(){
        if (ftp!=null && ftp.isConnected()) {
            try {
                ftp.logout();
                ftp.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void upload(String fileName,InputStream is){
    	 try {
			ftp.storeFile(fileName,is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**
     * ftp�ϴ��ļ�
     * @param f
     * @throws Exception
     */
    public static void upload(File f) throws Exception{
        if (f.isDirectory()) {
            ftp.makeDirectory(f.getName());
            ftp.changeWorkingDirectory(f.getName());
            String[] files=f.list();
            for(String fstr : files){
                File file1=new File(f.getPath()+"/"+fstr);
                if (file1.isDirectory()) {
                    upload(file1);
                    ftp.changeToParentDirectory();
                }else{
                    File file2=new File(f.getPath()+"/"+fstr);
                    FileInputStream input=new FileInputStream(file2);
                    ftp.storeFile(file2.getName(),input);
                    input.close();
                }
            }
        }else{
            File file2=new File(f.getPath());
            //InputStreamReader isr=new InputStreamReader(new FileInputStream(file2), "utf-8");
            FileInputStream input=new FileInputStream(file2);
            //String s=new String(file2.getName().getBytes("gbk"),"utf-8");
            System.out.println(file2.getName());
            ftp.storeFile(file2.getName(),input);
           
            input.close();
        }
    }
    
    /**
     * ������������
     * @param f
     * @param localBaseDir ����Ŀ¼
     * @param remoteBaseDir Զ��Ŀ¼
     * @throws Exception
     */
    public static void startDown(Ftp f,String localBaseDir,String remoteBaseDir ) throws Exception{
        if (FtpUtil.connectFtp(f)) {
            
            try { 
                FTPFile[] files = null; 
                boolean changedir = ftp.changeWorkingDirectory(remoteBaseDir); 
                if (changedir) { 
                    ftp.setControlEncoding("utf-8"); 
                    files = ftp.listFiles(); 
                    for (int i = 0; i < files.length; i++) { 
                        try{ 
                            downloadFile(files[i], localBaseDir, remoteBaseDir); 
                        }catch(Exception e){ 
                            logger.error("<"+files[i].getName()+">����ʧ��"); 
                        } 
                    } 
                } 
            } catch (Exception e) { 
                logger.error("���ع����г����쳣"); 
            } 
        }else{
            logger.error("����ʧ�ܣ�");
        }
        
    }
    
    
    /** 
     * 
     * ����FTP�ļ� 
     * ������Ҫ����FTP�ļ���ʱ�򣬵��ô˷��� 
     * ����<b>��ȡ���ļ��������ص�ַ��Զ�̵�ַ</b>�������� 
     * 
     * @param ftpFile 
     * @param relativeLocalPath 
     * @param relativeRemotePath 
     */ 
    private  static void downloadFile(FTPFile ftpFile, String relativeLocalPath,String relativeRemotePath) { 
        if (ftpFile.isFile()) {
            if (ftpFile.getName().indexOf("?") == -1) { 
                OutputStream outputStream = null; 
                try { 
                    File locaFile= new File(relativeLocalPath+ ftpFile.getName()); 
                    //�ж��ļ��Ƿ���ڣ������򷵻� 
                    if(locaFile.exists()){ 
                        return; 
                    }else{ 
                        outputStream = new FileOutputStream(relativeLocalPath+ ftpFile.getName()); 
                        ftp.retrieveFile(ftpFile.getName(), outputStream); 
                        outputStream.flush(); 
                        outputStream.close(); 
                    } 
                } catch (Exception e) { 
                   // logger.error(e);
                } finally { 
                    try { 
                        if (outputStream != null){ 
                            outputStream.close(); 
                        }
                    } catch (IOException e) { 
                       logger.error("����ļ����쳣"); 
                    } 
                } 
            } 
        } else { 
            String newlocalRelatePath = relativeLocalPath + ftpFile.getName(); 
            String newRemote = new String(relativeRemotePath+ ftpFile.getName().toString()); 
            File fl = new File(newlocalRelatePath); 
            if (!fl.exists()) { 
                fl.mkdirs(); 
            } 
            try { 
                newlocalRelatePath = newlocalRelatePath + '/'; 
                newRemote = newRemote + "/"; 
                String currentWorkDir = ftpFile.getName().toString(); 
                boolean changedir = ftp.changeWorkingDirectory(currentWorkDir); 
                if (changedir) { 
                    FTPFile[] files = null; 
                    files = ftp.listFiles(); 
                    for (int i = 0; i < files.length; i++) { 
                        downloadFile(files[i], newlocalRelatePath, newRemote); 
                    } 
                } 
                if (changedir){
                    ftp.changeToParentDirectory(); 
                } 
            } catch (Exception e) { 
            
            } 
        } 
    } 

    
    public static void main(String[] args) throws Exception{  
            Ftp f=new Ftp();
            f.setIpAddr("127.0.0.1");
            f.setUserName("lang");
            f.setPwd("123456");
            FtpUtil.connectFtp(f);
            File file = new File("D:/WordFile/java/workspace/JavaSE/blog/src/main/webapp/upload/Oracle����.txt");  
            //FtpUtil.upload(file);//���ļ��ϴ���ftp��
            FtpUtil.startDown(f,"D:/WordFile/java/workspace/JavaSE/blog/src/main/webapp/upload/","/");//����ftp�ļ�����
            System.out.println("ok");
          
       }

 
    
}