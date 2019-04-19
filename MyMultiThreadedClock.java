
public class MyMultiThreadedClock implements Runnable
{
    public Thread t;
    public String threadName;
    public MyClock m;
    
    public MyMultiThreadedClock(String _threadName, int _hours, int _minutes, int _seconds)
    {
        this.t = new Thread(this,_threadName);
        this.threadName = _threadName;
        this.m = new MyClock(_hours, _minutes, _seconds, _threadName);
    }
    
    public void run()
    {
        while(true)
        {
            this.m.increment();
            
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
    
    public void start () 
    {
        if (t == null)
            System.out.println("Thread called is null");
        else    
            t.start ();  
    }
    
    public static void main (String[] args)
    {
        MyMultiThreadedClock ilTime = new MyMultiThreadedClock("IL",7,0,0);
        ilTime.start();
        
        MyMultiThreadedClock ukTime = new MyMultiThreadedClock("UK",8,0,0);
        ukTime.start();
        
        MyMultiThreadedClock usTime = new MyMultiThreadedClock("US",9,0,0);
        usTime.start();
    }
}
