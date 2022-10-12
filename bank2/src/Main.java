import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (true) {
            System.out.print("\n\rMenu \r");
            System.out.print("\n\r1) Create Account \r");
            System.out.print("\n\r2) Open Account \r");
            System.out.print(("\n\r3) Exit "));
            System.out.print("\n\rEnter Choice :");
            int ch1= scan.nextInt();
            if(ch1==1) {
                System.out.print("Enter Name: ");
                String name= scan.next();
                System.out.print("Enter Password: ");
                String pas= scan.next();
                int no=1000+getnum();
                System.out.print("\n Your account no: "+no);
                if(no==-1){
                    System.out.print("\n Error!...");
                    break;
                }
                customber obj=new customber(no,name,pas);
                obj.addCustomber(obj);
            }else if (ch1==2){
                System.out.print("Enter account no: ");
                int ano=scan.nextInt();
                customber emt=new customber();
                List<customber> listcustomber=emt.getcustomber();
                for(customber obj1: listcustomber) {
                    System.out.print(obj1.accno);
                    if (obj1.accno == ano) {
                        System.out.print("Enter password: ");
                        String pas = scan.next();
                        if (obj1.pass.equals(pas)) {
                            System.out.print("\nAccount opened");
                            System.out.print("\n\r Menu");
                            System.out.print("\n\r 1)Saving");
                            System.out.print("\n\r 2)Locker");
                            System.out.print("\n\r 3)Loan");
                            System.out.print("\n\r 4)Back");
                            System.out.print("\n\r Enter choice: ");
                            int ch2= scan.nextInt();
                            if (ch2==1){
                                System.out.print("\n\r Menu");
                                System.out.print("\n\r 1)Saving");
                                System.out.print("\n\r 2)Fd");
                                System.out.print("\n\r 3)RD");
                                System.out.print("\n\r 4)Current");
                                System.out.print("\n\r 5)Back");
                                System.out.print("\n\r Enter choice: ");
                                int ch3= scan.nextInt();
                                if(ch3==1){
                                    System.out.print("\n\r Menu");
                                    System.out.print("\n\r 1)open");
                                    System.out.print("\n\r 2)deposit");
                                    System.out.print("\n\r 3)withdraw");
                                    System.out.print("\n\r 4)balance");
                                    System.out.print("\n\r 5)Back");
                                    System.out.print("\n\r Enter choice: ");
                                    int ch4= scan.nextInt();
                                    if(ch4==1){
                                        save obj2=new save(1000,1,2,obj1);
                                        obj2.addsave(obj2);
                                        System.out.print("\n\r Created ");
                                    }
                                    else{
                                        save temp=new save();
                                        List<save> lissave=temp.getsave();
                                        for(save obj:lissave){
                                            if(obj.accno==obj1.accno){
                                                if(ch4==2){
                                                    System.out.print("\n\r Enter amount: ");
                                                    int amo= scan.nextInt();
                                                    obj.deposit(amo);
                                                } else if (ch4==3) {
                                                    System.out.print("\n\r Enter amount: ");
                                                    int amo= scan.nextInt();
                                                    int result=obj.withdraw(amo);
                                                    if(result==-1){
                                                        System.out.print("\n\r Check Balance");
                                                    }
                                                } else if (ch4==4) {
                                                    System.out.print("\n\r Balance: "+obj.getBal());
                                                }
                                            }
                                        }
                                    }
                                } else if (ch3==2) {
                                    System.out.print("\n\r Menu");
                                    System.out.print("\n\r 1)open");
                                    System.out.print("\n\r 2)withdraw");
                                    System.out.print("\n\r 3)balance");
                                    System.out.print("\n\r 4)Back");
                                    System.out.print("\n\r Enter choice: ");
                                    int ch4= scan.nextInt();
                                    if(ch4==1){
                                        System.out.print("\n\r Enter number of year(5-50): ");
                                        int yea= scan.nextInt();
                                        LocalDate date=LocalDate.now().plusYears(yea);
                                        System.out.print("\n\r Enter amount: ");
                                        int amo= scan.nextInt();
                                        fd obj2=new fd(amo,1,6,date,obj1);
                                        obj2.addfd(obj2);
                                    }
                                    else{
                                        fd temp=new fd();
                                        List<fd>lisfd=temp.getfd();
                                        for(fd obj:lisfd){
                                            if(obj.accno== obj1.accno){
                                                if(ch4==2){
                                                    int amo= obj.withdraw();
                                                    System.out.print("\n\r Amount: "+amo);
                                                } else if (ch4==3) {
                                                    System.out.print("\n\r Balance: "+obj.getbal());
                                                }
                                            }
                                        }
                                    }
                                } else if (ch3==3) {
                                    System.out.print("\n\r Menu");
                                    System.out.print("\n\r 1)open");
                                    System.out.print("\n\r 2)deposit");
                                    System.out.print("\n\r 3)withdraw");
                                    System.out.print("\n\r 4)Balance");
                                    System.out.print("\n\r 5)Back");
                                    System.out.print("\n\r Enter choice: ");
                                    int ch4= scan.nextInt();
                                    if(ch4==1){
                                        System.out.print("\n\r Enter amount: ");
                                        int amo= scan.nextInt();
                                        System.out.print("enter months: ");
                                        int mon= scan.nextInt();
                                        LocalDate date=LocalDate.now().plusMonths(mon);
                                        rd obj2=new rd(amo,1,6,date,obj1,amo);
                                        obj2.addrd(obj2);
                                    }
                                    else{
                                        rd temp=new rd();
                                        List<rd>lisrd=temp.getrd();
                                        for(rd obj:lisrd){
                                            if(obj.accno== obj1.accno){
                                                if(ch4==2){
                                                    obj.deposit(obj.amo);
                                                    System.out.print("\n\r Deposited");
                                                } else if (ch4==3) {
                                                    System.out.print("\n\r Amount: "+obj.withdraw());
                                                } else if (ch4==4) {
                                                    System.out.print("\n\r Balance: "+ obj.getbal());
                                                }
                                            }
                                        }
                                    }
                                } else if (ch3==4) {
                                    System.out.print("\n\r Menu");
                                    System.out.print("\n\r 1)open");
                                    System.out.print("\n\r 2)deposit");
                                    System.out.print("\n\r 3)withdraw");
                                    System.out.print("\n\r 4)balance");
                                    System.out.print("\n\r 5)Back");
                                    System.out.print("\n\r Enter choice: ");
                                    int ch4= scan.nextInt();
                                    if(ch4==1){
                                        curr obj2=new curr(2000,obj1);
                                        System.out.print("\n\r Created ");
                                    }
                                    else{
                                        curr temp=new curr();
                                        List<curr>liscurr=temp.getcurr();
                                        for(curr obj:liscurr){
                                            if(obj.accno== obj1.accno){
                                                if(ch4==2){
                                                    System.out.print("enter amount: ");
                                                    int amo= scan.nextInt();
                                                    obj.deposit(amo);
                                                } else if (ch4==3) {
                                                    System.out.print("enter amount: ");
                                                    int amo= scan.nextInt();
                                                    obj.withdraw(amo);
                                                } else if (ch4==3) {
                                                    System.out.print("\n\r Balance: "+obj.getBal());
                                                }
                                            }
                                        }
                                    }
                                }else{
                                    continue;
                                }
                            } else if (ch2==2) {
                                System.out.print("\n\r Menu");
                                System.out.print("\n\r 1)new");
                                System.out.print("\n\r 2)open");
                                System.out.print("\n\r Enter choice: ");
                                int ch3= scan.nextInt();
                                if(ch3==1){
                                    System.out.print("\n\r Enter lockerno: ");
                                    int no= scan.nextInt();
                                    System.out.print("\n\r Password: ");
                                    String pas1= scan.next();
                                    lock obj2=new lock(no,pas1,obj1);
                                    obj2.addlock(obj2);
                                    System.out.print("\n\r Added");
                                } else if (ch3==2) {
                                    System.out.print("\n\r Enter lockerno: ");
                                    int no= scan.nextInt();
                                    System.out.print("\n\r Password: ");
                                    String pas1= scan.next();
                                    lock temp=new lock();
                                    List<lock>lislock=temp.getlock();
                                    for(lock obj:lislock){
                                        if(obj.getlocker(no,pas1)==1){
                                            System.out.print("\n\r Opened");
                                        }
                                    }
                                }
                            } else if (ch2==3) {
                                System.out.print("\n\r Menu");
                                System.out.print("\n\r 1)new");
                                System.out.print("\n\r 2)pay");
                                System.out.print("\n\r Enter choice: ");
                                int ch3= scan.nextInt();
                                if(ch3==1){
                                    System.out.print("\n\r enter amount: ");
                                    int amo= scan.nextInt();
                                    System.out.print("\n\r Enter year");
                                    int yea= scan.nextInt();
                                    home obj2=new home(10,amo,yea,obj1);
                                    obj2.addhome(obj2);
                                }
                                else{
                                    home temp=new home();
                                    List<home>lishome=temp.gethome();
                                    for(home obj:lishome){
                                        if(obj.accno==obj1.accno){
                                            obj.reduce();
                                            System.out.print("\n\r payed");
                                        }
                                    }
                                }
                            } else {
                               continue;
                            }
                        }
                        break;
                    }
                }
            } else if (ch1==3) {
                break;
            } else{
                System.out.print("Invalid");
            }

        }
    }
    static int getnum(){
        String filename="accno.bin";
        int o;
        try{
            FileInputStream fio = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fio);
            try{
                o=ois.read();
            }catch (EOFException e2){
                o=999;
            }
            o++;
            try {
                FileOutputStream fos = new FileOutputStream(filename);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.write(o);
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return o;
        }catch (IOException e1){
            e1.printStackTrace();
        }
        return -1;
    }
}