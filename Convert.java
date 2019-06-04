package converter;
import java.io.*;
import java.io.File;
public class Convert {
    private FileInputStream fileinput;
	private FileInputStream fileinput2;
	private FileOutputStream fileoutput;
	private FileOutputStream fileoutput2;
	public void copy(String d){
        try{
            String s1="C:/test/API/"+d;
            fileinput2 = new FileInputStream(s1);
            String s2="D:/java/test/"+d;
            fileoutput = new FileOutputStream(s2,true);
            int i;  
            do{
               i=fileinput2.read();
              if(i!=-1){
                  fileoutput.write((char)i);
                }
               }while(i!=-1);

        } catch (Exception e) {
           }
    }
    public void extension(String d){
        //create
        try{
        String s4="D:/java/"+d;        
        String s5=d.replace(".txt",".pdf");
        String s6="D:/java/"+s5;
        File newfile=new File(s6);
        newfile.createNewFile();
        //copy old file to new file

        fileinput = new FileInputStream(s4);
        fileoutput2 = new FileOutputStream(s6,true);
        int i;  
        do{
           i=fileinput.read();
           System.out.print(i);
          if(i!=-1){
              fileoutput2.write((char)i);
            }
           }while(i!=-1);
           //delete old file
        }catch(Exception e){}
    }
     public void delete(String d){
        String s3="D:/java/" + d;//write the path where operation perform
        File file1 = new File(s3);
        file1.delete();
    }
	public static void main(String[] args) throws IOException{ 
        Convert obj=new Convert();
        File file = new File("D:/java");//write the path wjava here operation perform
        String a[] = file.list();
        for(String name:a){
              String ext=".txt";
              if(name.endsWith(ext)){
                    //obj.copy(name);
                    obj.extension(name);  
                      //obj.delete(name);
                      
                }           
        }
	}

}
