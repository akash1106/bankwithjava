import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class rd extends customber{
    int bal,sat,in,amo;
    LocalDate per;
    rd(){
        this.bal=0;
    }
    rd(int bal,int sat,int in,LocalDate per,customber obj1,int amo){
        super(obj1);
        this.bal=bal;
        this.in=in;
        this.per=per;
        this.sat=sat;
        this.amo=amo;
    }
    int getbal(){
        return this.bal;
    }
    void deposit(int amo){
        this.bal=this.bal+amo;
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
    void addrd(rd obj1){
        List<rd> listrd=getrd();
        listrd.add((rd) obj1);
        String filename="fr.bin";
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (rd obj : listrd) {
                oos.writeObject(obj);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();}
    }
    List<rd> getrd(){
        List<rd> listrd=new ArrayList<rd>();
        String filename="rd.bin";
        try {
            FileInputStream fio = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fio);
            Object o;
            while (true) {
                try {
                    o = ois.readObject();
                    if (o instanceof fd) {
                        listrd.add((rd) o);
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
        return listrd;
    }
}
