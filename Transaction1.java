import java.util.Date;
import java.text.*;

public class Transaction1{
    private Date transactionTime;
    
    public Transaction1(Date transactionTime) //check
    {
        this.transactionTime = transactionTime;
    }

    public String gettransactionTime(){
        Date DateTime = new Date(); //creates a date object
        SimpleDateFormat fT = new SimpleDateFormat ("yyyyMMddhhmm");
        return fT.format(DateTime); 
    }

    public String gettransactionID(){ //use the transactionTime to create the TID
        /*append the getTransactionID to the cinema code */
        return "hello";
    }

}

//XXXYYYYMMDDhhmm (Y : year, M : month, D : day, h : hour, m : minutes, XXX : cinema code in letters)