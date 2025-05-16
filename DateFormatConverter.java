package homework1;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
Program description:A date format converter
Author:Atilla Uğur 220401080
E-mail address:atillaugur35@outlook.com
Homework Number:Homework part 3
*/

public class DateFormatConverter {
    // tried a function for JPANEL using JFrame
    static String JPanelDateInput()
    {
        JFrame f = new JFrame();
        String date = JOptionPane.showInputDialog(f,"Please enter date");

        return date;
    }
    public static void main(String[] args)
    {
        // declared the variables and made a choice based system because I could not find a way to differentiate between days that are less than 12 and months 
            int day,month,year;
            String days,months,years;
            days = "";
            months = "";
            years = "";
            day = 0;
            month = 0;
            year = 0;
            int choice =Integer.parseInt(JOptionPane.showInputDialog(null,"Please choose the format you wish to enter the date in (1-MM/DD/YYYY 2-DD/MM/YYYY 3-YYYY/MM/DD)"));
           
            // splitting the date string into an array to turn the values easily into integer values
            String date = JPanelDateInput();
            String datesarray[] = date.split("/");

            switch(choice)
            {
            case 1:
            month = Integer.parseInt(datesarray[0]);
            day = Integer.parseInt(datesarray[1]);
            year = Integer.parseInt(datesarray[2]);      
            months = datesarray[0];
            days = datesarray[1];
            years = datesarray[2];
        
            break;
            
            case 2:
            day = Integer.parseInt(datesarray[0]);
            month = Integer.parseInt(datesarray[1]);
            year = Integer.parseInt(datesarray[2]);
            days = datesarray[0];
            months = datesarray[1];
            years = datesarray[2];
            break;
            
            case 3:
            year = Integer.parseInt(datesarray[0]);
            month = Integer.parseInt(datesarray[1]);
            day = Integer.parseInt(datesarray[2]);

            years = datesarray[0];
            months = datesarray[1];
            days = datesarray[2];
            break;

            default:
            JOptionPane.showMessageDialog(null,"Date is not valid");
            break;
            }
            // checking about the 29th February
            if(day == 29 && month == 2)
            {
                if(year % 4 != 0)
                {
                JOptionPane.showMessageDialog(null,"Date is not valid,terminating...");
                System.exit(0);
                }
            } 
            // checking if the month values is more than 12 
            if(month > 12)
            {
                JOptionPane.showMessageDialog(null,"There is 12 months in a year");
                System.exit(0);
            }
            // checking which months has 31 days in them 
            switch(month)
            {
                case 2:
                case 4:
                case 6:
                case 9:
                case 11:
                if(day == 31)
                {
                JOptionPane.showMessageDialog(null,"Date is not valid");
                System.exit(0);
                }
                break;

                default:
                break;
            }
            // did a couple of assignments to rearrange the date string and turn it into european format 

            datesarray[0] = days;
            datesarray[1] = months;
            datesarray[2] = years;

            date = datesarray[0];
            date += ".";
            date += datesarray[1];
            date += ".";
            date += datesarray[2];
            JOptionPane.showMessageDialog(null,"Date format converted:");
            JOptionPane.showMessageDialog(null,date);
    }
        
  }
