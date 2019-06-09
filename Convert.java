package converter;
import java.io.*;
import java.io.File;
import java.util.Scanner;
public class Convert {
    private FileInputStream fileinput;
	private FileInputStream fileinput2;
	private FileOutputStream fileoutput;
	private FileOutputStream fileoutput2;
	private Scanner sc;
	private static Scanner sc2;
	
    public void copy(String d,String path){
        try{
        	sc = new Scanner(System.in);
        	
        	String ext=sc.next();
            String s1=path+"/"+d;
            fileinput2 = new FileInputStream(s1);
            String s2=ext+"/"+d;
            fileoutput = new FileOutputStream(s2,true);
            int i;  
            do{
                  i=fileinput2.read();
                 if(i!=-1){
                    fileoutput.write((char)i);
                 }
             }while(i!=-1);

        } catch (Exception e) {}
   }
   public void extension(String d,String path,String ext,String ext1){
        //create
    try{
        String s4=path+"/"+d;
        String s5=d.replace(ext,ext1);
        String s6=path+"/"+s5;
          File newfile=new File(s6);
           newfile.createNewFile();
        //copy old file to new file

        fileinput = new FileInputStream(s4);
        fileoutput2 = new FileOutputStream(s6,true);
        int i;  
          do{
             i=fileinput.read();
             //  System.out.print(i);
               if(i!=-1){
                fileoutput2.write((char)i);
               }
           }while(i!=-1);
            System.out.println("Success");
      }catch(Exception e){}
   }
     public void delete(String d,String path){
        String s3=path+"/" +d;//write the path where operation perform
        File file1 = new File(s3);
        file1.delete();
        System.out.println("Success");
     }
	public static void main(String[] args) throws IOException{ 
         Convert obj=new Convert();
          sc2 = new Scanner(System.in);
            System.out.println("Enter the path of folder=");
               String path=sc2.next();
                 File file = new File(path);//write the path java here operation perform
                   String a[] = file.list();
                     System.out.println("Enter the extension name with dot=");
  	                   String ext=sc2.next();
  	                     System.out.println("Enter the convert extension name with dot=");
	                       String ext1=sc2.next();
                             for(String name:a){
                                if(name.endsWith(ext)){
                                     //obj.copy(name,path);
                                       obj.extension(name,path,ext,ext1);  
                                     //obj.delete(name,path);
				}
       	                      }                                   
        
	}

}
