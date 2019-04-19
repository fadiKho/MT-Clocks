
public class MyClock
{
    private int hours; // hours counter
    private int minutes; // minutes counter
    private int seconds; // seconds counter
    private String name; // clock/time-zone name
    
    static final int MAX_SECONDS = 60; // number of seconds in a minute
    static final int MAX_MINUTES = 60; // number of minutes in an hour
    static final int MAX_HOURS = 24; // number of hours in a day

    /* constructor
     * @param _hours - hours counter
     * @param _minutes - minutes counter
     * @param _seconds - seconds counter
     * @param _name - name attribute
     */
    public MyClock(int _hours, int _minutes, int _seconds, String _name)
    {
        this.hours = _hours;
        this.minutes = _minutes;
        this.seconds = _seconds;
        this.name = _name;
    }
    
    /* returns the seconds attribute value of a clock
     * @return int seconds attribute
     */
    public int getSeconds()
    {
        return this.seconds;
    }
    
    /* returns the minutes attribute value of a clock
     * @return int minutes attribute
     */
    public int getMinutes()
    {
        return this.minutes;
    }
    
    /* returns the hours attribute value of a clock
     * @return int hours attribute
     */
    public int getHours()
    {
        return this.hours;
    }
    
    /* returns the name attribute value of a clock
     * @return String name attribute
     */
    public String getName()
    {
        return this.name;
    }
    
    /* set the seconds attribute value to be equal to _seconds param value
     * @param int seconds value to be set
     * @return nothing
     */
    public void setSeconds(int _seconds)
    {
        this.seconds = _seconds;
    }
    
    /* set the minutes attribute value to be equal to _minutes param value
     * @param int minutes value to be set
     * @return nothing
     */
    public void setMinutes(int _minutes)
    {
        this.minutes = _minutes;
    }
    
    /* set the hours attribute value to be equal to _hours param value
     * @param int hours value to be set
     * @return nothing
     */
    public void setHours(int _hours)
    {
        this.hours = _hours;
    }
    
    /* set the name attribute value to be equal to _name param value
     * @param String name value to be set
     * @return nothing
     */
    public void setName(String _name)
    {
        this.name = _name;
    }
    
    /* prints the current time of a clock object
     * @return nothing
     */
    public void print()
    {
        System.out.println(this.name + " time now is:" + this.getHours() + ":" + this.getMinutes() + ":" + this.getSeconds());
    }
    
    /* increments time of a clock object in 1 second
     * @return nothing
     */
    public void increment()
    {
        if(incrementSeconds())
            if(incrementMinutes())
                incrementHours();
        
        this.print();
    }
    
    /* calculates the seconds attribute value after 1 second, sets
     * it accordingly, and returns true if minutes also need to be updated
     * (if the current second counter was 59 before incrementing), and false 
     * otherwise.
     * @return boolean true/false
     */
    private boolean incrementSeconds()
    {
        int temp;
        if (this.getSeconds() == MAX_SECONDS - 1)
        {
            this.setSeconds(0);
            return true;
        }
        else
        {
            temp = this.getSeconds() + 1;
            this.setSeconds(temp);
            return false;
        }
    }
    
    /* calculates the minutes attribute value after 1 minute, sets
     * it accordingly, and returns true if hours also need to be updated
     * (if the current minutes counter was 59 before incrementing), and false 
     * otherwise.
     * @return boolean true/false
     */
    private boolean incrementMinutes()
    {
        int temp;
        if (this.getMinutes() == MAX_MINUTES - 1)
        {
            this.setMinutes(0);
            return true;
        }
        else
        {
            temp = this.getMinutes() + 1;
            this.setMinutes(temp);
            return false;
        }
    }
    
    /* calculates the hours attribute value after 1 hour,  and sets
     * it accordingly.
     * @return nothing
     */
    private void incrementHours()
    {
        int temp;
        if (this.getHours() == MAX_HOURS - 1)
        {
            this.setHours(0);
        }
        else
        {
            temp = this.getHours() + 1;
            this.setHours(temp);
        }
    }
    
    public static void main(String[] args)
    {
        MyClock ilTime = new MyClock(7,55,55,"Israel");
        while (true)
        {
            ilTime.increment();
            
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
