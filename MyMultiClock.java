
public class MyMultiClock
{
    public static void main (String[] args)
    {
        MyClock[] myClockArr = new MyClock[3];
        
        myClockArr[0] = new MyClock(7,0,0,"Israel");
        myClockArr[1] = new MyClock(8,0,0,"UK");
        myClockArr[2] = new MyClock(9,0,0,"US");
        
        while(true)
        {
            for(int i = 0; i < myClockArr.length; i++)
            {
                myClockArr[i].increment();
            }
            
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println("Thread was interrupted");
            }
        }
    }
}
