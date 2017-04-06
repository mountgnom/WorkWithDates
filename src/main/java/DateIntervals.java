package main.java;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import net.sf.jasperreports.engine.JRDefaultScriptlet;

/**
 * Created by TDzhahangirov on 31.03.2017.
 */
public class DateIntervals  extends JRDefaultScriptlet {


    public static void main(String[] args) {

        //main.java.DateIntervals di= new main.java.DateIntervals();

        Date date1;// = new Date();
        Date date2;// = new Date();
        //c2.add(Calendar.DATE,1);

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTimeInMillis(0);
        c1.set(2017, 0, 1);
        c2.setTimeInMillis(0);
        c2.set(2017, 11, 31);
        date1 = c1.getTime();
        date2 = c2.getTime();

        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        //System.out.println("date1: " + dateFormat.format( date1 ) );
        //System.out.println("date2: " + dateFormat.format( date2 ) );

        String str = getIntervalNameFromDateInterval(date1,date2);
        //System.out.println(str);
    }


    public static Calendar getCalendarFromDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    /**
     *
     * @param date1
     * @param date2
     * @return описание врменного интервала между двумя датами на русском языке,
     * например "2-е полугодие 2017 года" или "2 и 3 кварталы 2016 года"
     */
    public static String getIntervalNameFromDateInterval(Date date1, Date date2){
        String result = "";

        Calendar c1 = getCalendarFromDate(date1);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int month1 = c1.get(Calendar.MONTH)+1;
        int year1 = c1.get(Calendar.YEAR);

        Calendar c2 = getCalendarFromDate(date2);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        int month2 = c2.get(Calendar.MONTH)+1;
        int year2 = c2.get(Calendar.YEAR);
        System.out.println(day2);
        //дата, следующая за кокончанием интервала, проверяем ,если она =1 значит предыдущеая дата была концом месяца
        Calendar c3 = getCalendarFromDate(date2);

        c3.add(Calendar.DATE,1);
        int day3 = c3.get(Calendar.DAY_OF_MONTH);

        if(year1!=year2)return "";
        if(day1!=1) return "";
        if(day3!=1)return "";

        //к этому момнету мы проверили, что даты из одного года, первая является началом какого то месяца а вторая концом какого то месяца
        if(month1==1) {
            switch (month2) {
                case 1:  result="январь";break;
                case 3:  result= "1 квартал";break;
                case 6:  result= "1-е полугодие";break;
                case 9:  result= "1,2 и 3 кварталы";break;
                case 12: result= "год";break;
                default: return "";
            }
        }
        if(month1==2) {
            switch (month2) {
                case 2:  result = "февраль";break;
                default: return "";
            }
        }
        if(month1==3) {
            switch (month2) {
                case 3:  result = "март";break;
                default: return "";
            }
        }

        if(month1==4) {
            switch (month2) {
                case 4:  result = "апрель";break;
                case 6:  result = "2 квартал";break;
                case 9:  result = "2 и 3 кварталы";break;
                case 12:  result = "2,3 и 4 кварталы";break;
                default: return "";
            }
        }
        if(month1==5) {
            switch (month2) {
                case 5:  result = "май";break;
                default: return "";
            }
        }
        if(month1==6) {
            switch (month2) {
                case 6:  result = "июнь";break;
                default: return "";
            }
        }
        if(month1==7) {
            switch (month2) {
                case 7:  result = "июль";break;
                case 9:  result = "3 квартал";break;
                case 12: result = "2-е полугодие";break;
                default: return "";
            }
        }
        if(month1==8) {
            switch (month2) {
                case 8:  result = "август";break;
                default: return "";
            }
        }
        if(month1==9) {
            switch (month2) {
                case 9:  result = "сентрябрь";break;
                default: return "";
            }
        }
        if(month1==10) {
            switch (month2) {
                case 10: result = "октябрь";break;
                case 12: result = "4 квартал";break;
                default: return "";
            }
        }
        if(month1==11) {
            switch (month2) {
                case 11: result = "ноябрь";break;
                default: return "";
            }
        }
        if(month1==12) {
            switch (month2) {
                case 12: result = "декабрь";break;
                default: return "";
            }
        }

        //обрабатываем что получили
        if(result.equals("")) return result;
        if(result.equals("год")) {
            result = String.valueOf(year1)+" "+result;
        }else{
            result = result+" "+String.valueOf(year1)+" года";
        }

        return result;
    }
}
