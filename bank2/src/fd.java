import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class fd extends customber{
    int bal,sat,in;
    LocalDate  per;
    fd(){
        this.bal=0;
    }
    fd(int bal,int sat,int in,LocalDate per,customber obj1){
        super(obj1);
        this.bal=bal;
        this.sat=sat;
        this.in=in;
        this.per=per;
    }
    int getbal(){
        return this.bal;
    }
    int withdraw(){
        LocalDate da=LocalDate.now() ;
        if(da.compareTo(this.per)>0){
            return this.bal;
        }
        else{
            return -1;
        }
    }
    void inte(){
        int in=(this.bal/100)*this.in;
        this.bal=this.bal+in;
    }
    void addfd(fd obj1){
        List<fd> listfd=getfd();
        listfd.add((fd) obj1);
        String filename="fd.bin";
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (fd obj : listfd) {
                oos.writeObject(obj);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();}
    }
    List<fd> getfd(){
        List<fd> listfd=new ArrayList<fd>();
        String filename="fd.bin";
        try {
            FileInputStream fio = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fio);
            Object o;
            while (true) {
                try {
                    o = ois.readObject();
                    if (o instanceof fd) {
                        listfd.add((fd) o);
                    } else {
                        System.out.println("error");
                    }
                } catch (EOFException e1) {
                    break;
                }
            }
        }catch (IOException | ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        return listfd;
    }
}
